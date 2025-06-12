package huevitos.huevitos.Database;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void crearTablas() {
        System.out.println("Iniciando creación de tablas...");

        crearTablaNegocio();
        crearTablaUsuarios();
        crearTablaClientes();
        crearTablaLotesGallinas();
        crearTablaProduccion();
        crearTablaVentas();
        crearTablaEgresos();
        crearTablaPerdidas();

        System.out.println("Tablas creadas exitosamente");
    }

    private static void crearTablaNegocio() {
        String sql = """
        CREATE TABLE IF NOT EXISTS negocios (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL UNIQUE
        );
        """;
        ejecutarSQL(sql, "negocios");
    }

    private static void crearTablaUsuarios() {
        String sql = """
        CREATE TABLE IF NOT EXISTS usuarios (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            correo TEXT NOT NULL UNIQUE,
            contrasena TEXT NOT NULL,
            negocio_id INTEGER,
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "usuarios");
    }

    private static void crearTablaClientes() {
        String sql = """
        CREATE TABLE IF NOT EXISTS clientes (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            numero_celular TEXT,
            negocio_id INTEGER,
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "clientes");
    }

    private static void crearTablaLotesGallinas() {
        String sql = """
        CREATE TABLE IF NOT EXISTS lotes_gallinas (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            lote_id INTEGER NOT NULL,
            fecha_ingreso TEXT NOT NULL,
            semanas INTEGER DEFAULT 0,
            cantidad_gallinas INTEGER NOT NULL,
            raza TEXT,
            activo BOOLEAN DEFAULT 1,
            negocio_id INTEGER,
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "lotes_gallinas");
    }

    private static void crearTablaProduccion() {
        String sql = """
        CREATE TABLE IF NOT EXISTS produccion (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha TEXT NOT NULL,
            tipo_huevo TEXT NOT NULL,
            cantidad INTEGER NOT NULL,
            lote_id INTEGER,
            porcentaje_produccion REAL,
            negocio_id INTEGER,
            FOREIGN KEY (lote_id) REFERENCES lotes_gallinas(id),
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "produccion");
    }

    private static void crearTablaVentas() {
        String sql = """
        CREATE TABLE IF NOT EXISTS ventas (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha_venta TEXT NOT NULL,
            cliente_id INTEGER,
            tipo_huevo TEXT,
            tipo_cubeta TEXT,
            cantidad INTEGER NOT NULL,
            precio_unitario REAL,
            total REAL,
            pago BOOLEAN DEFAULT 0,
            fecha_pago TEXT,
            negocio_id INTEGER,
            FOREIGN KEY (cliente_id) REFERENCES clientes(id),
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "ventas");
    }

    private static void crearTablaEgresos() {
        String sql = """
        CREATE TABLE IF NOT EXISTS egresos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha TEXT NOT NULL,
            tipo TEXT NOT NULL,
            articulo TEXT NOT NULL,
            cantidad INTEGER DEFAULT 1,
            valor REAL NOT NULL,
            descripcion TEXT,
            negocio_id INTEGER,
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "egresos");
    }

    private static void crearTablaPerdidas() {
        String sql = """
        CREATE TABLE IF NOT EXISTS perdidas (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            fecha TEXT NOT NULL,
            tipo TEXT NOT NULL,
            articulo TEXT NOT NULL,
            cantidad INTEGER NOT NULL,
            descripcion TEXT,
            valor_estimado REAL,
            negocio_id INTEGER,
            FOREIGN KEY (negocio_id) REFERENCES negocios(id)
        );
        """;
        ejecutarSQL(sql, "perdidas");
    }

    private static void ejecutarSQL(String sql, String nombreTabla) {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("✓ Tabla '" + nombreTabla + "' creada/verificada");

        } catch (Exception e) {
            System.err.println("✗ Error creando tabla '" + nombreTabla + "': " + e.getMessage());
            e.printStackTrace();
        }
    }
}

