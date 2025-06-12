package huevitos.huevitos.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuController {

    @FXML
    private AnchorPane contentPane;  // El contenedor central donde se cargan las vistas

    // Métodos de navegación
    @FXML
    private void goToHome() {
        loadView("Home.fxml");  // Cargar la vista de Home
    }

    @FXML
    private void goToProduccion() {
        loadView("Produccion.fxml");  // Cargar la vista de Producción
    }

    @FXML
    private void goToVentas() {
        loadView("Ventas.fxml");  // Cargar la vista de Ventas
    }

    @FXML
    private void goToCobros() {
        loadView("Cobros.fxml");  // Cargar la vista de Cobros
    }

    @FXML
    private void goToEgresos() {
        loadView("Egresos.fxml");  // Cargar la vista de Egresos
    }

    @FXML
    private void goToPerdidas() {
        loadView("Perdidas.fxml");  // Cargar la vista de Pérdidas
    }

    @FXML
    private void goToContabilidad() {
        loadView("Contabilidad.fxml");  // Cargar la vista de Contabilidad
    }

    @FXML
    private void goToInventario() {
        loadView("Inventario.fxml");  // Cargar la vista de Inventario
    }

    // Método común para cargar cualquier vista
    private void loadView(String fxmlFile) {
        try {
            // Aquí cargarías el FXML correspondiente a la vista seleccionada
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane view = loader.load();  // Cargar la vista FXML

            // Establecer la vista cargada en el contenedor central
            contentPane.getChildren().setAll(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

