package com.bitqba;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.apache.commons.logging.LogFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {

        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("nauta.conf")) {

            prop.load(input);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(2 );
        }

        String url = "https://mi.cubacel.net/primary/_-ijqJlSHh?";
        HtmlPage page = null;
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setUseInsecureSSL(true);
        CookieManager cookieManager= webClient.getCookieManager();
        cookieManager.setCookiesEnabled(true);

        Cookie c1 = new Cookie("mi.cubacel.net", "guestUserProfile", prop.getProperty("guestUserProfile"));
        Cookie c2 = new Cookie("mi.cubacel.net", "portaluser", prop.getProperty("portaluser"));
        Cookie c3 = new Cookie("mi.cubacel.net", "DRUTT_DSERVER_SESSIONID", prop.getProperty("DRUTT_DSERVER_SESSIONID") );


        cookieManager.addCookie(c1);
        cookieManager.addCookie(c2);
        cookieManager.addCookie(c3);



        try {
            String searchUrl = (url);
            page = webClient.getPage(searchUrl);
        }catch(Exception e){
            e.printStackTrace();
        }
        String result = page.getBody().asXml();
        List<DomElement> data = page.getElementsById("myStat_3001");
        List<DomElement> dataN = page.getElementsById("myStat_bonusDataN");
        List<DomElement> dataSMS = page.getElementsById("myStat_bonusSMSI");
        List<DomElement> dataVOZ = page.getElementsById("myStat_bonusVOZI");
        List<DomElement> data_bonus = page.getElementsById("myStat_bonusData");

       new Main().showData ("Paquete de Datos", data);
        new Main().showData ("Bono Nacional", dataN);
        new Main().showData ("Bono SMS", dataSMS);
        new Main().showData ("Bono Minutos", dataVOZ);
        new Main().showData ("Bono Internet", data_bonus);



    }

    private void showData(String descripttion, List<DomElement> data){
        for (DomElement element : data) {
            String value = element.getAttribute("data-text").toString();
            String info = element.getAttribute("data-info").toString();
            if (!value.equals("0")){
                System.out.println(descripttion+" " + value +" " + info);
            }

        }
    }
}
