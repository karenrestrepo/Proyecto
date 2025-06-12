module huevitos.huevitos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens huevitos.huevitos to javafx.fxml;
    exports huevitos.huevitos;
}