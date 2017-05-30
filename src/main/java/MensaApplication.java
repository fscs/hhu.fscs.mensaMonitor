package main.java;

import javafx.application.Application;
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
    }

    public static void main(String[] args) {
        launch();
    }
}
