package main.java.xml.parser;

import main.java.meal.Meal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Timo on 28.05.17.
 */
public class MensaXmlParser {

    /**
     * @param xml
     * @return
     */
    public Document getDocumentByString(String xml) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public ArrayList<Meal> getMealsByDocument(Document doc) {
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("ROW");
        ArrayList<Meal> mealList = new ArrayList<>();

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                mealList.add(new Meal(
                        eElement.getAttribute("STUDIERENDE"),
                        eElement.getAttribute("BEDIENSTETE"),
                        eElement.getAttribute("AUSGABETEXT"),
                        eElement.getAttribute("MENSA"),
                        eElement.getAttribute("ZSNAMEN"),
                        eElement.getAttribute("PFAD"),
                        eElement.getAttribute("DATUM")
                ));
            }
            System.out.println(mealList.get(i));
            System.out.println();
        }

        return mealList;
    }
}
