package main.java.gui.meal;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import main.java.meal.Meal;

import java.util.ArrayList;

/**
 * Created by Timo on 30.05.17.
 */
public class MealController {
    @FXML private ImageView picture;
    @FXML private TextFlow nameAndPrice;
    @FXML private TextFlow ingredients;

    private Meal meal;

    public MealController(Meal meal) {
        this.meal = meal;
    }

}
