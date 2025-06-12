package huevitos.huevitos.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Aquí se crea o abre el archivo .db automáticamente
                connection = DriverManager.getConnection("jdbc:sqlite:datos_huevitos.db");
                System.out.println("Conexión establecida con SQLite");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return connection;
    }
}

