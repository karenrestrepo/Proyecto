package huevitos.huevitos;

import huevitos.huevitos.Database.DatabaseInitializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HuevitoApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            DatabaseInitializer.crearTablas();
            System.out.println("Base de datos inicializada correctamente");
        } catch (Exception e) {
            System.err.println("Error al inicializar base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HuevitoApplication.class.getResource("/Vistas/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 494, 356);
        stage.setTitle("Sistema Huevitos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}