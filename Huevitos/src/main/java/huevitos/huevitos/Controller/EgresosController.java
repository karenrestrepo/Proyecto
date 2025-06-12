package huevitos.huevitos.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EgresosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private ComboBox<?> cbTipo;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TableColumn<?, ?> tcArticulo;

    @FXML
    private TableColumn<?, ?> tcCantidad;

    @FXML
    private TableColumn<?, ?> tcFecha;

    @FXML
    private TableColumn<?, ?> tcValor;

    @FXML
    private TableView<?> tvCompras;

    @FXML
    private TextField txtArticulo;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtValor;

    @FXML
    void onAgregar(ActionEvent event) {

    }

    @FXML
    void onTipo(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}

