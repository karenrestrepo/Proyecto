package huevitos.huevitos.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:datos_huevitos.db";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.sqlite.JDBC");

                connection = DriverManager.getConnection(
                        DATABASE_URL + "?foreign_keys=on&journal_mode=WAL"
                );

                connection.setAutoCommit(true);

                System.out.println("✓ Conexión establecida con SQLite: " + DATABASE_URL);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("✗ Driver SQLite no encontrado: " + e.getMessage());
            throw new SQLException("Driver SQLite no disponible", e);
        } catch (SQLException e) {
            System.err.println("✗ Error al conectar con la base de datos: " + e.getMessage());
            throw e;
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    System.out.println("✓ Conexión cerrada correctamente");
                }
            } catch (SQLException e) {
                System.err.println("✗ Error al cerrar conexión: " + e.getMessage());
            } finally {
                connection = null;
            }
        }
    }

    public static boolean testConnection() {
        try (Connection testConn = getConnection()) {
            return testConn != null && !testConn.isClosed();
        } catch (SQLException e) {
            System.err.println("✗ Test de conexión falló: " + e.getMessage());
            return false;
        }
    }
}

