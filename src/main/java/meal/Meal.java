package main.java.meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Timo on 28.05.17.
 */
public class Meal {
    private double priceStudent;
    private double priceEmployee;
    private String name, ingredients, pictureUrl, foodBar;
    private String mensaName;
    private LocalDateTime availabilityDate;

    public Meal(String priceStudent, String priceEmployee, String name, String mensa, String ingredients,
                String pictureUrl, String date, String foodBar) {
        this.name = name;
        this.mensaName = mensa;
        this.ingredients = ingredients;
        this.pictureUrl = pictureUrl;
        this.foodBar = foodBar;
        priceStudent = priceStudent.replace(",", ".");
        priceEmployee = priceEmployee.replace(",", ".");
        this.priceStudent = Double.parseDouble(priceStudent);
        this.priceEmployee = Double.parseDouble(priceEmployee);

        // Parsing date(String) to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.availabilityDate = LocalDateTime.parse(date, formatter);
    }

    public String getMensaName() {
        return mensaName;
    }

    public LocalDateTime getAvailabilityDate() {
        return availabilityDate;
    }

    @Override
    public String toString() {
        String string = "Name: " + name + "\n";
        string += "Mensa: " + mensaName + "\n";
        string += "Ingredients: " + ingredients + "\n";
        string += "Price Student: " + priceStudent + "\n";
        string += "Price Employee: " + priceEmployee + "\n";
        string += "Date: " + availabilityDate.toString() + "\n";
        string += "FoodBar: " + foodBar + "\n";
        string += "URL: " + pictureUrl + "\n";
        return string;
    }
}
