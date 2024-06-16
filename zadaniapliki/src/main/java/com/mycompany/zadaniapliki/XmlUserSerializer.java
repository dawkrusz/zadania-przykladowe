/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniapliki;

/**
 *
 * @author dawid
 */
import interfejsy.UserSerializerInterface;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XmlUserSerializer implements UserSerializerInterface {

    @Override
    public void serialize(List<User> users, String filename) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("Users");
        doc.appendChild(rootElement);

        for (User user : users) {
            Element userElement = doc.createElement("User");

            Element firstName = doc.createElement("FirstName");
            firstName.appendChild(doc.createTextNode(user.getFirstName()));
            userElement.appendChild(firstName);

            Element lastName = doc.createElement("LastName");
            lastName.appendChild(doc.createTextNode(user.getLastName()));
            userElement.appendChild(lastName);

            Element age = doc.createElement("Age");
            age.appendChild(doc.createTextNode(String.valueOf(user.getAge())));
            userElement.appendChild(age);

            Element email = doc.createElement("Email");
            email.appendChild(doc.createTextNode(user.getEmail()));
            userElement.appendChild(email);

            rootElement.appendChild(userElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(source, result);
    }

    @Override
    public List<User> deserialize(String filename) throws Exception {
        List<User> users = new ArrayList<>();
        File file = new File(filename);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("User");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String firstName = element.getElementsByTagName("FirstName").item(0).getTextContent();
                String lastName = element.getElementsByTagName("LastName").item(0).getTextContent();
                int age = Integer.parseInt(element.getElementsByTagName("Age").item(0).getTextContent());
                String email = element.getElementsByTagName("Email").item(0).getTextContent();

                users.add(new User(firstName, lastName, age, email));
            }
        }
        return users;
    }
}