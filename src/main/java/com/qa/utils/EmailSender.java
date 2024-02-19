package com.qa.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {


    public static void main(String[] args) {
        String from = "xxxxxx@gmail.com";
        String pass = "lyyr kcyc nago vjlj";
        String[] toAddresses = {

                "yxxx@gmail.com"
        };
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        try {
            for (String toAddress : toAddresses) {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
                message.setSubject("Otomasyon Gunluk Kosu Raporu Hakkinda");


                // E-posta içeriğini createHtmlContent metodu ile çağırarak ayarla
                String htmlContent = createHtmlContent();
                message.setContent(htmlContent, "text/html");

                // E-postayı gönder
                Transport.send(message);
                System.out.println("Sent message to " + toAddress + " successfully....");
            }

        } catch (MessagingException mex) {
            System.out.println("Error: " + mex.getMessage());
            mex.printStackTrace();
        }
    }

    // HTML içeriğini oluşturan metot
    private static String createHtmlContent() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Test Kosum Raporu</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #007bff;\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #007bff;\n" +
                "            color: white;\n" +
                "            padding: 20px 0;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 40px;\n" +
                "            background-color: #b3d7ff;\n" +
                "            border-radius: 10px;\n" +
                "            margin: 20px;\n" +
                "            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        .footer {\n" +
                "            background-color: #333;\n" +
                "            color: white;\n" +
                "            text-align: center;\n" +
                "            padding: 20px 0;\n" +
                "            position: fixed;\n" +
                "            bottom: 0;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "        .marquee {\n" +
                "            white-space: nowrap;\n" +
                "            overflow: hidden;\n" +
                "            box-sizing: border-box;\n" +
                "            animation: marquee 15s linear infinite;\n" +
                "        }\n" +
                "\n" +
                "        @keyframes marquee {\n" +
                "            0% {\n" +
                "                transform: translateX(100%);\n" +
                "            }\n" +
                "            100% {\n" +
                "                transform: translateX(-100%);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        h1, h2, p, a {\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        a {\n" +
                "            color: #007bff;\n" +
                "            text-decoration: none;\n" +
                "            font-weight: bold;\n" +
                "        }\n" +
                "\n" +
                "        a:hover {\n" +
                "            color: #0056b3;\n" +
                "        }\n" +
                "\n" +
                "        .report-icon {\n" +
                "            font-size: 24px;\n" +
                "            margin-right: 10px;\n" +
                "        }\n" +
                "\n" +
                "        .responsive-img {\n" +
                "            max-width: 100%;\n" +
                "            height: auto;\n" +
                "        }\n" +
                "\n" +
                "        .team-list {\n" +
                "            margin-top: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .team-member {\n" +
                "            display: inline-block;\n" +
                "            margin: 0 15px;\n" +
                "            font-style: italic;\n" +
                "            color: #555;\n" +
                "        }\n" +
                "\n" +
                "        .team-member-info {\n" +
                "            margin-top: 10px;\n" +
                "            font-size: 14px;\n" +
                "            color: #777;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"header\">\n" +
                "        <h1>Test Kosum Raporu</h1>\n" +
                "    </div>\n" +
                "    <div class=\"content\">\n" +
                "        <h2>Test ve kalite her seydir.</h2>\n" +
                "        <p>Merhaba, Kosum basarili bir sekilde yapildi. Rapora erisim saglamak icin linke tiklayabilirsin.</p>\n" +
                "        <a href=\"target/cucumber/report.html\">\n" +
                "            <i class=\"fas fa-file-alt report-icon\"></i> Test Kosum Raporu\n" +
                "        </a>\n" +
                "\n" +
                "        <div class=\"team-list\">\n" +
                "            <p><strong>Ekip Uyeleri:</strong></p>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Ali KARABULUT</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/alikarabulut\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Anil GECER</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/anılgecer\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Buket YILDIZ</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/buketyildiz\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Burak CANBAZ</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/burakcanbaz\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Dilara KANPAKOGLU</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/dilarakanpakoglu\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Elif CAGLAR</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/elifcaglar\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Gizem DEMIR</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/gizemdemir\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Hilal ICEN</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/hilalicen\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Naim OZBAG</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/naimozbag\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Osman TAS</strong><br>\n" +
                "                LinkedIn: <a href=\"linkedin.com/in/osmantas\">LinkedIn</a>\n" +
                "            </div>\n" +
                "            <div class=\"team-member\">\n" +
                "                <strong>Yasin BULGAN</strong><br>\n" +
                "                LinkedIn: <a href=\"https://www.linkedin.com/in/yasinbulgan/\">LinkedIn</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"footer\">\n" +
                "        <p class=\"marquee\">&copy; 2024 Test. Tüm hakları saklıdır.</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}