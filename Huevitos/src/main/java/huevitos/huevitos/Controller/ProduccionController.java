package huevitos.huevitos.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProduccionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private MenuButton mbLote;

    @FXML
    private MenuButton mbTipoHuevo;

    @FXML
    private TableColumn<?, ?> tcCantidad;

    @FXML
    private TableColumn<?, ?> tcFecha;

    @FXML
    private TableColumn<?, ?> tcLote;

    @FXML
    private TableColumn<?, ?> tcPorcentajeProduccion;

    @FXML
    private TableColumn<?, ?> tcTipoHuevo;

    @FXML
    private TableView<?> tvProduccion;

    @FXML
    private TextField txtFecha;

    @FXML
    void onAgregar(ActionEvent event) {

    }

    @FXML
    void onLote(ActionEvent event) {

    }

    @FXML
    void onTipoHuevo(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}

