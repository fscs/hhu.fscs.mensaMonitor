package main.java.xml;

import main.java.meal.Meal;
import main.java.meal.Mensa;
import main.java.xml.http.client.MensaHttpClient;
import main.java.xml.parser.MensaXmlParser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by Timo on 28.05.17.
 */
public class MensaXml {
    private MensaHttpClient client;
    private MensaXmlParser parser;

    private String userpass;
    private String url;

    private HashMap<Mensa, String> hashMap;

    public MensaXml() {
        Properties properties = null;
        try {
            properties = getProperties();
        } catch (IOException e) {
            System.err.println("ERROR: Properties not readable.");
            e.printStackTrace();
            System.exit(1);
        }
        userpass = properties.getProperty("userpass");
        url = properties.getProperty("url");

        initHashMap();
    }

    /**
     * @Todo
     */
    private void initHashMap() {
        hashMap = new HashMap<>();
        hashMap.put(Mensa.VITA, "campus vita (D)");
        hashMap.put(Mensa.SOUTH_MENSA, "Essenausgabe Süd (D)");
        hashMap.put(Mensa.GREAT_MENSA, "Universitätsstraße (D)");
    }

    public ArrayList<Meal> receiveMeals() throws IOException {
        MensaHttpClient client = new MensaHttpClient();
        MensaXmlParser parser = new MensaXmlParser();
        return parser.getMealsByDocument(parser.getDocumentByString(client.sendRequest(url, userpass)));
    }

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        System.out.println(this.getClass().getResource("").getPath());
        BufferedInputStream stream = new BufferedInputStream(this.getClass().getResourceAsStream
                ("/authentication/data.prop"));
        properties.load(stream);
        stream.close();
        return properties;
    }

    public ArrayList<Meal> getMealsByDateTime(LocalDate date, ArrayList<Meal> plist) {
        ArrayList<Meal> list = (ArrayList<Meal>) plist.clone();
        return (ArrayList<Meal>) list.stream()
                .filter(m -> m.getAvailabilityDate().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    /**
     * @return
     */
    public ArrayList<Meal> getMealsByMensa(Mensa mensa, ArrayList<Meal> plist) {
        ArrayList<Meal> list = (ArrayList<Meal>) plist.clone();
        return (ArrayList<Meal>) list.stream()
                .filter(m -> m.getMensaName().equals(hashMap.get(mensa)))
                .collect(Collectors.toList());
    }
}
