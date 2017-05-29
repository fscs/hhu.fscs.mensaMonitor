package main.java.xml;

import main.java.meal.Meal;
import main.java.xml.http.client.MensaHttpClient;
import main.java.xml.parser.MensaXmlParser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Timo on 28.05.17.
 */
public class MensaXml {
    private MensaHttpClient client;
    private MensaXmlParser parser;

    private String userpass;
    private String url;

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
}
