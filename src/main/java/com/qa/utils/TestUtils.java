package com.qa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TestUtils {
    public static final long WAIT = 10;

    // XML dosyasından veri çekme metodu
    public HashMap<String, String> parseStringXML(InputStream file) throws Exception {
        HashMap<String, String> stringMap = new HashMap<>();

        try {
            // XML işlemleri için DocumentBuilder oluştur
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Dokümanı oluştur
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            // Root elementi al
            Element root = document.getDocumentElement();

            // Tüm "string" elementlerini al
            NodeList nList = document.getElementsByTagName("string");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    // Her bir elementin key-value'yu haritaya ekle
                    stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringMap;
    }

    // Tarih ve saat bilgisini almak için metod
    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Log oluşturmak için metod
    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

    public static void main(String[] args) {
        // Örnek kullanım
        TestUtils testUtils = new TestUtils();
        try {
            InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream("example.xml");
            HashMap<String, String> stringMap = testUtils.parseStringXML(inputStream);

            // Alınan verileri yazdır
            System.out.println("Parsed XML data:");
            for (String key : stringMap.keySet()) {
                System.out.println(key + ": " + stringMap.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
