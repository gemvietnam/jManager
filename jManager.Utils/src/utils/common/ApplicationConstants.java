/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author b.dang
 */
public class ApplicationConstants {

    public static enum DatabaseConfig {
        
        Config("config"),
        Driver("driver"),
        URL("url"),
        UserName("username"),
        Password("password"),
        ShowSQL("showsql"),
        Dialect("dialect"),
        Auto("auto"),
        Provider("provider"),
        Session("session");

        private String enumValue;

        private DatabaseConfig(String s) {
            this.enumValue = s;
        }

        public String GetDescription() {
            return this.enumValue;
        }

        public String GetValue() {
            String result = "";

            try {
                //ClassLoader classLoader = ApplicationConstants.class.getClassLoader();
                //File file1 = new File(classLoader.getResource(GetConfigFilePath()).getFile());

                File file = new File(GetConfigFilePath());

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);

                doc.getDocumentElement().normalize();

                System.out.println("Element :" + this.enumValue);

                result = doc.getElementsByTagName(this.enumValue).item(0).getTextContent();
            } catch (Exception e) {
                Logs.Record(e);
            }

            return result;
        }
    }

    public static String RESOURCES_DIR = "config";
    public static String CONFIG_FILE_NAME = "jManager.config.xml";

    public static String APPLICATION_PATH = new File(RESOURCES_DIR).getAbsolutePath();
    //public static String APPLICATION_PATH = ApplicationConstants.class.getProtectionDomain().getCodeSource().getLocation().toString();

    public static String GetConfigFilePath() {
        //return APPLICATION_PATH + File.separator + RESOURCES_DIR + File.separator + CONFIG_FILE_NAME;
        return APPLICATION_PATH + File.separator + CONFIG_FILE_NAME;
    }

    public static boolean GetConfig() {
        boolean isLoaded = true;
        try {
            //ClassLoader classLoader = ApplicationConstants.class.getClassLoader();
            //File file1 = new File(classLoader.getResource(GetConfigFilePath()).getFile());

            File file = new File(GetConfigFilePath());

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("config");

        } catch (Exception e) {
            isLoaded = false;
            Logs.Record(e);
        }

        return isLoaded;
    }
}
