package huevitos.huevitos.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;

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

    @FXML
    private void initialize() {
        loadView("Home.fxml");
    }


    // Método común para cargar cualquier vista
    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/" + fxmlFile));
            Parent view = loader.load();

            // Asegura que el contenido anterior se borre
            contentPane.getChildren().clear();
            contentPane.getChildren().add(view);

            // Haz que el nuevo contenido se ajuste al tamaño del AnchorPane
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

