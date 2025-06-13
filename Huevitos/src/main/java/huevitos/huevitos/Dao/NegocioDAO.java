package huevitos.huevitos.Dao;

import huevitos.huevitos.Database.DatabaseConnection;
import huevitos.huevitos.Model.Negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NegocioDAO {


    public static Negocio obtenerNegocioPorId(int id) {
        String sql = "SELECT id, nombre FROM negocios WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Negocio negocio = new Negocio();
                negocio.setNombreNegocio(rs.getString("nombre"));
                return negocio;
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener negocio por ID: " + e.getMessage());
        }

        return null;
    }

    // Método para obtener un negocio por nombre
    public static Negocio obtenerNegocioPorNombre(String nombre) {
        String sql = "SELECT id, nombre FROM negocios WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Negocio negocio = new Negocio();
                negocio.setNombreNegocio(rs.getString("nombre"));
                return negocio;
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener negocio por nombre: " + e.getMessage());
        }

        return null;
    }

    // Método para obtener todos los negocios
    public static List<Negocio> obtenerTodosLosNegocios() {
        List<Negocio> negocios = new ArrayList<>();
        String sql = "SELECT id, nombre FROM negocios ORDER BY nombre";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Negocio negocio = new Negocio();
                negocio.setNombreNegocio(rs.getString("nombre"));
                negocios.add(negocio);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los negocios: " + e.getMessage());
        }

        return negocios;
    }

    // Método para crear un nuevo negocio
    public static boolean crearNegocio(String nombre) {
        String sql = "INSERT INTO negocios (nombre) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            int resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                System.out.println("Negocio creado exitosamente: " + nombre);
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Error al crear negocio: " + e.getMessage());
        }

        return false;
    }

    // Método para verificar si existe un negocio
    public static boolean existeNegocio(String nombre) {
        String sql = "SELECT COUNT(*) FROM negocios WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();

            return rs.next() && rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de negocio: " + e.getMessage());
        }

        return false;
    }

    // Método para obtener el ID de un negocio por nombre
    public static int obtenerIdNegocio(String nombre) {
        String sql = "SELECT id FROM negocios WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener ID de negocio: " + e.getMessage());
        }

        return -1;
    }

    // Método para actualizar nombre de negocio
    public static boolean actualizarNombreNegocio(int id, String nuevoNombre) {
        String sql = "UPDATE negocios SET nombre = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, id);

            int resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                System.out.println("Nombre de negocio actualizado exitosamente");
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar nombre de negocio: " + e.getMessage());
        }

        return false;
    }
}
