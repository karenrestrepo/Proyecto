package huevitos.huevitos.Dao;

import huevitos.huevitos.Database.DatabaseConnection;
import huevitos.huevitos.Model.Usuario;
import huevitos.huevitos.Model.Negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuariosDAO {

    public static boolean registrarUsuario(String nombre, String correo, String contrasena, String nombreNegocio) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción

            // Primero crear o verificar el negocio
            int negocioId = crearOVerificarNegocio(conn, nombreNegocio);
            if (negocioId == -1) {
                conn.rollback();
                return false;
            }

            // Verificar si el correo ya existe
            if (existeCorreo(conn, correo)) {
                System.out.println("El correo ya está registrado");
                conn.rollback();
                return false;
            }

            // Encriptar contraseña
            String contrasenaEncriptada = encriptarContrasena(contrasena);

            // Insertar usuario
            String sqlUsuario = "INSERT INTO usuarios (nombre, correo, contrasena, negocio_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlUsuario)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, correo);
                pstmt.setString(3, contrasenaEncriptada);
                pstmt.setInt(4, negocioId);

                int resultado = pstmt.executeUpdate();
                if (resultado > 0) {
                    conn.commit();
                    System.out.println("Usuario registrado exitosamente");
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            }

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                System.err.println("Error en rollback: " + ex.getMessage());
            }
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Error restaurando autoCommit: " + e.getMessage());
            }
        }
    }

    // Método para autenticar usuario
    public static Usuario autenticarUsuario(String correo, String contrasena) {
        String sql = """
            SELECT u.id, u.nombre, u.correo, u.contrasena, u.negocio_id, n.nombre as nombre_negocio 
            FROM usuarios u 
            INNER JOIN negocios n ON u.negocio_id = n.id 
            WHERE u.correo = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String contrasenaEncriptada = encriptarContrasena(contrasena);
                String contrasenaDB = rs.getString("contrasena");

                if (contrasenaEncriptada.equals(contrasenaDB)) {
                    // Crear objeto Usuario
                    Usuario usuario = new Usuario();
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));

                    // Crear objeto Negocio
                    Negocio negocio = new Negocio();
                    negocio.setNombreNegocio(rs.getString("nombre_negocio"));
                    usuario.setEmpresa(negocio);

                    System.out.println("Login exitoso para: " + usuario.getNombre());
                    return usuario;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            } else {
                System.out.println("Usuario no encontrado");
            }

        } catch (Exception e) {
            System.err.println("Error al autenticar usuario: " + e.getMessage());
        }

        return null;
    }

    // Método auxiliar para crear o verificar negocio
    private static int crearOVerificarNegocio(Connection conn, String nombreNegocio) throws SQLException {
        // Verificar si el negocio ya existe
        String sqlBuscar = "SELECT id FROM negocios WHERE nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlBuscar)) {
            pstmt.setString(1, nombreNegocio);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        }

        // Si no existe, crearlo
        String sqlInsertar = "INSERT INTO negocios (nombre) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsertar, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nombreNegocio);
            int resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }

        return -1;
    }

    // Método auxiliar para verificar si existe un correo
    private static boolean existeCorreo(Connection conn, String correo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    // Método para encriptar contraseña usando SHA-256
    private static String encriptarContrasena(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al encriptar contraseña: " + e.getMessage());
            return contrasena; // Fallback (no recomendado en producción)
        }
    }
}
