package huevitos.huevitos.Database;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void crearTablas() {
        crearTablaUsuarios();
        crearTablaProduccion();
        crearTablaVentas();
        crearTablaClientes();
        crearTablaLotesGallinas();
        crearTablaEgresos();
        crearTablaPerdidas();
        crearTablaNegocio();

    }

    private static void crearTablaProduccion() {
        String sql = """
        CREATE TABLE IF NOT EXISTS produccion (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha TEXT NOT NULL,
            tipo_huevo TEXT,
            cantidad INTEGER,
            lote_id INTEGER,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);
    }

    private static void crearTablaClientes() {
        String sql = """
        CREATE TABLE IF NOT EXISTS clientes (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            numero_celular TEXT,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);
    }

    private static void crearTablaPerdidas() {
        String sql = """
        CREATE TABLE IF NOT EXISTS perdida (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha TEXT NOT NULL,
            tipo TEXT,
            articulo TEXT,
            cantidad INTEGER,
            descripcion TEXT,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);
    }

    private static void crearTablaEgresos() {
        String sql = """
        CREATE TABLE IF NOT EXISTS Egresos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha TEXT NOT NULL,
            tipo TEXT,
            articulo TEXT,
            cantidad INTEGER,
            valor DOUBLE,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);
    }

    private static void crearTablaLotesGallinas() {
        String sql = """
        CREATE TABLE IF NOT EXISTS lotesGallinas (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha_ingreso TEXT NOT NULL,
            lote_id INTEGER;
            semanas INTEGER,
            cantidad_gallinas INTEGER,
            activo BOOLEAN,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);


    }

    private static void crearTablaVentas() {
        String sql = """
        CREATE TABLE IF NOT EXISTS ventas (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha_venta TEXT NOT NULL,
            cliente TEXT,
            cubeta TEXT,
            cantidad INTEGER,
            pago BOOLEAN,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);

    }

    private static void crearTablaUsuarios() {
        String sql = """
        CREATE TABLE IF NOT EXISTS usuarios (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            correo TEXT NOT NULL,
            contrasena TEXT,
            negocio_id TEXT
        );
    """;
        ejecutarSQL(sql);
    }

    private static void crearTablaNegocio() {
        String sql = """
        CREATE TABLE IF NOT EXISTS negocios (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL
        );
    """;
        ejecutarSQL(sql);
    }

    private static void ejecutarSQL(String sql) {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println("Error creando tabla: " + e.getMessage());
        }
    }
}

