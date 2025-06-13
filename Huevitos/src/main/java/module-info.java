module huevitos.huevitos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens huevitos.huevitos to javafx.fxml;
    opens huevitos.huevitos.Model;
    opens huevitos.huevitos.Dao;
    opens huevitos.huevitos.Controller;
    exports huevitos.huevitos;
    exports huevitos.huevitos.Model;
    exports huevitos.huevitos.Dao;
    exports huevitos.huevitos.Controller;
}