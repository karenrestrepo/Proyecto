package huevitos.huevitos.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<?, ?> bchVentas;

    @FXML
    private PieChart pchIngresosEgresos;

    @FXML
    void initialize() {
    }

}


