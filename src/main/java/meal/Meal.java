package main.java.meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Timo on 28.05.17.
 */
public class Meal {
    private double priceStudent;
    private double priceEmployee;
    private String name;
    private String mensa;
    private String ingredients;
    private String pictureUrl;
    private LocalDateTime dateTime;

    public Meal(String priceStudent, String priceEmployee, String name, String mensa, String ingredients,
                String pictureUrl, String date) {
        this.name = name;
        this.mensa = mensa;
        this.ingredients = ingredients;
        this.pictureUrl = pictureUrl;
        priceStudent = priceStudent.replace(",", ".");
        priceEmployee = priceEmployee.replace(",", ".");
        this.priceStudent = Double.parseDouble(priceStudent);
        this.priceEmployee = Double.parseDouble(priceEmployee);

        // Parsing date(String) to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.dateTime = LocalDateTime.parse(date, formatter);
    }

    @Override
    public String toString() {
        String string = "Name: " + name + "\n";
        string += "Mensa: " + mensa + "\n";
        string += "Ingredients: " + ingredients + "\n";
        string += "Price Student: " + priceStudent + "\n";
        string += "Price Employee: " + priceEmployee + "\n";
        string += "Date: " + dateTime.toString() + "\n";
        string += "URL: " + pictureUrl + "\n";
        return string;
    }
}
