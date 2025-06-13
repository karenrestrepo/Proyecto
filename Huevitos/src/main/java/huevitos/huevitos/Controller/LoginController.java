package huevitos.huevitos.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import huevitos.huevitos.Dao.UsuariosDAO;
import huevitos.huevitos.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtNuevaContrasena;

    @FXML
    private TextField txtNuevoCorreo;

    @FXML
    private TextField txtNuevoNegocio;

    @FXML
    private TextField txtNuevoNombre;

    public static Usuario usuarioActual;

    @FXML
    void onLogin(ActionEvent event) {
        String correo = txtCorreo.getText().trim();
        String contrasena = txtContrasena.getText();

        if(correo.isEmpty() || contrasena.isEmpty()){
            mostrarAlerta("Error", "Por favor complete todos los campos", Alert.AlertType.WARNING);
            return;
        }
        if (!esCorreoValido(correo)) {
            mostrarAlerta("Error", "Por favor ingrese un correo válido", Alert.AlertType.WARNING);
            return;
        }

        try {

            Usuario usuario = UsuariosDAO.autenticarUsuario(correo, contrasena);

            if (usuario != null) {
                usuarioActual = usuario;
                mostrarAlerta("Éxito", "Bienvenido " + usuario.getNombre(), Alert.AlertType.INFORMATION);

                // Cargar la ventana principal
                cargarVentanaPrincipal();

            } else {
                mostrarAlerta("Error", "Correo o contraseña incorrectos", Alert.AlertType.ERROR);
                limpiarCamposLogin();
            }

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al conectar con la base de datos: " + e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Error en login: " + e.getMessage());
        }
    }

    @FXML
    void onRegister(ActionEvent event) {
        String nombre = txtNuevoNombre.getText().trim();
        String correo = txtNuevoCorreo.getText().trim();
        String contrasena = txtNuevaContrasena.getText();
        String negocio = txtNuevoNegocio.getText().trim();

        // Validaciones básicas
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || negocio.isEmpty()) {
            mostrarAlerta("Error", "Por favor complete todos los campos de registro", Alert.AlertType.WARNING);
            return;
        }

        if (!esCorreoValido(correo)) {
            mostrarAlerta("Error", "Por favor ingrese un correo válido", Alert.AlertType.WARNING);
            return;
        }

        if (contrasena.length() < 6) {
            mostrarAlerta("Error", "La contraseña debe tener al menos 6 caracteres", Alert.AlertType.WARNING);
            return;
        }

        try {
            // Intentar registrar usuario
            boolean registroExitoso = UsuariosDAO.registrarUsuario(nombre, correo, contrasena, negocio);

            if (registroExitoso) {
                mostrarAlerta("Éxito", "Usuario registrado exitosamente. Ya puede iniciar sesión.", Alert.AlertType.INFORMATION);
                limpiarCamposRegistro();

                // Opcional: llenar automáticamente los campos de login
                txtCorreo.setText(correo);
                txtContrasena.requestFocus();

            } else {
                mostrarAlerta("Error", "No se pudo registrar el usuario. El correo podría ya estar en uso.", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al registrar usuario: " + e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Error en registro: " + e.getMessage());
        }
    }

    @FXML
    void initialize() {

    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private boolean esCorreoValido(String correo) {
        return correo.contains("@") && correo.contains(".") && correo.length() > 5;
    }

    private void limpiarCamposLogin() {
        txtCorreo.clear();
        txtContrasena.clear();
    }

    private void limpiarCamposRegistro() {
        txtNuevoNombre.clear();
        txtNuevoCorreo.clear();
        txtNuevaContrasena.clear();
        txtNuevoNegocio.clear();
    }

    private void cargarVentanaPrincipal() {
        try {
            // Obtener el stage actual
            Stage stageActual = (Stage) btnLogin.getScene().getWindow();

            // Cargar la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Menu.fxml"));
            Parent root = loader.load();

            // Crear nueva escena
            Scene scene = new Scene(root);

            // Configurar el stage
            stageActual.setTitle("Sistema Huevitos - " + usuarioActual.getEmpresa().getNombreNegocio());
            stageActual.setScene(scene);
            stageActual.setMaximized(false); // Maximizar ventana
            stageActual.centerOnScreen();

        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo cargar la ventana principal: " + e.getMessage(), Alert.AlertType.ERROR);
            System.err.println("Error cargando ventana principal: " + e.getMessage());
        }
    }

    // Método estático para cerrar sesión
    public static void cerrarSesion() {
        usuarioActual = null;
    }

    // Método estático para obtener el usuario actual
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

}
