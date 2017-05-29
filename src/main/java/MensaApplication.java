package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.xml.MensaXml;


/**
 * Created by Timo on 02.05.17.
 */
public class MensaApplication extends Application {

    @Override public void start(Stage primaryStage) throws Exception {
        new MensaXml().receiveMeals();
    }

    public static void main(String[] args) {
        launch();
    }
}
