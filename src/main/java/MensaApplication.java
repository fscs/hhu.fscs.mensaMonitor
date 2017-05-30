package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.meal.Mensa;
import main.java.xml.MensaXml;

import java.time.LocalDate;


/**
 * Created by Timo on 02.05.17.
 */
public class MensaApplication extends Application {

    @Override public void start(Stage primaryStage) throws Exception {
        MensaXml mensaXml = new MensaXml();
        mensaXml.getMealsByMensa(Mensa.GREAT_MENSA,
                mensaXml.getMealsByDateTime(LocalDate.now(), mensaXml.receiveMeals()))
                .forEach(System.out::println);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainScene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
