package main.java.xml.http.client;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;


/**
 * Created by Timo on 28.05.17.
 */
public class MensaHttpClient {

    /**
     * @param urlSpec
     * @param userpass Has to be formatted like "USERNAME:PASSWORD"
     * @return
     * @throws IOException
     */
    public String sendRequest(String urlSpec, String userpass) throws IOException {
        //"http://cms1.rz.uni-duesseldorf.de/App/SpeisePlan/speiseplan.xml"
        //"hhu-app" + ":" + "awedxy12"

        URL url = new URL(urlSpec);
        URLConnection uc = url.openConnection();
        String basicAuth = "Basic " + new Base64().encode(userpass.getBytes());
        uc.setRequestProperty("Authorization", basicAuth);
        InputStream in = uc.getInputStream();
        StringBuilder stringBuilder = new StringBuilder("");
        new Scanner(in, "utf-8").useDelimiter(System.lineSeparator()).
                forEachRemaining(s -> stringBuilder.append(s + System.lineSeparator()));
        return stringBuilder.toString();
    }

}
