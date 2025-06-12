package huevitos.huevitos.Dao;
import huevitos.huevitos.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduccionDAO {

    public static void guardarProduccion(String negocioId, String fecha, String tipoHuevo, int cantidad, String lote) {
        String sql = "INSERT INTO produccion(negocio_id, fecha, tipo_huevo, cantidad, lote) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, negocioId);
            pstmt.setString(2, fecha);
            pstmt.setString(3, tipoHuevo);
            pstmt.setInt(4, cantidad);
            pstmt.setString(5, lote);

            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar producción: " + e.getMessage());
        }
    }

    public static List<String> obtenerProduccion(String usuarioId) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM produccion WHERE usuario_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String registro = rs.getString("fecha") + " - " + rs.getString("tipo_huevo")
                        + " - " + rs.getInt("cantidad") + " - " + rs.getString("lote");
                lista.add(registro);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar producción: " + e.getMessage());
        }
        return lista;
    }


}

