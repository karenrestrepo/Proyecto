package huevitos.huevitos.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;

public class InventarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tcArticuloActivos;

    @FXML
    private TableColumn<?, ?> tcArticuloInsumos;

    @FXML
    private TableColumn<?, ?> tcArticuloOtros;

    @FXML
    private TableColumn<?, ?> tcArticuloRepuestos;

    @FXML
    private TableColumn<?, ?> tcCAntidadActivos;

    @FXML
    private TableColumn<?, ?> tcCantidadHuevos;

    @FXML
    private TableColumn<?, ?> tcCantidadInsumos;

    @FXML
    private TableColumn<?, ?> tcCantidadLotes;

    @FXML
    private TableColumn<?, ?> tcCantidadOtros;

    @FXML
    private TableColumn<?, ?> tcCantidadRepuestos;

    @FXML
    private TableColumn<?, ?> tcConsumoInsumos;

    @FXML
    private TableColumn<?, ?> tcFechaLotes;

    @FXML
    private TableColumn<?, ?> tcIdLotes;

    @FXML
    private TableColumn<?, ?> tcRazaLotes;

    @FXML
    private TableColumn<?, ?> tcSemanasLote;

    @FXML
    private TableColumn<?, ?> tcTipoHuevos;

    @FXML
    private TableColumn<?, ?> tcUsadasOtros;

    @FXML
    private TableColumn<?, ?> tcUsadasRepuestos;

    @FXML
    private TitledPane tpActivos;

    @FXML
    private TitledPane tpHuevos;

    @FXML
    private TitledPane tpInsumos;

    @FXML
    private TitledPane tpLotes;

    @FXML
    private TitledPane tpOtros;

    @FXML
    private TitledPane tpRepuestos;

    @FXML
    private TableView<?> tvActivos;

    @FXML
    private TableView<?> tvHuevos;

    @FXML
    private TableView<?> tvInsumos;

    @FXML
    private TableView<?> tvLotes;

    @FXML
    private TableView<?> tvOtros;

    @FXML
    private TableView<?> tvRepuestos;

    @FXML
    void initialize() {

    }

}

