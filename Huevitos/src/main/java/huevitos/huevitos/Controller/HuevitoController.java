package huevitos.huevitos.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

import java.io.IOException;

public class HuevitoController {

    @FXML
    private AnchorPane contentPane;

    private void loadView(String fxml) {
        try {
            Node node = FXMLLoader.load(getClass().getResource("/huevitos/huevitos/" + fxml));
            contentPane.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToHome() {
        loadView("Home.fxml");
    }

    @FXML
    private void goToProduccion() {
        loadView("Produccion.fxml");
    }

    @FXML
    private void goToVentas() {
        loadView("Ventas.fxml");
    }

    @FXML
    private void goToCobros() {
        loadView("Cobros.fxml");
    }

    @FXML
    private void goToEgresos() {
        loadView("Egresos.fxml");
    }

    @FXML
    private void goToPerdidas() {
        loadView("Perdidas.fxml");
    }

    @FXML
    private void goToContabilidad() {
        loadView("Contabilidad.fxml");
    }

    @FXML
    private void goToInventario() {
        loadView("Inventario.fxml");
    }
}

