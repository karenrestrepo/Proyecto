package huevitos.huevitos.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class CobrosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrarDetalle;

    @FXML
    private Label clienteNombreLabel;

    @FXML
    private VBox detalleContainer;

    @FXML
    private TableColumn<?, ?> tcAcciónDeuda;

    @FXML
    private TableColumn<?, ?> tcCantidadCubetas;

    @FXML
    private TableColumn<?, ?> tcCubeta;

    @FXML
    private TableColumn<?, ?> tcDeudaCliente;

    @FXML
    private TableColumn<?, ?> tcDíasDeuda;

    @FXML
    private TableColumn<?, ?> tcNombreCliente;

    @FXML
    private TableColumn<?, ?> tcValorcubeta;

    @FXML
    private TableView<?> tvClientes;

    @FXML
    private TableView<?> tvCompras;

    @FXML
    void initialize() {
    }

}
