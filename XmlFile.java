package sample_javadom_parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class XmlFile {
 
    public static final String xmlFilePath = "C:\\Users\\Alyssa\\eclipse-workspace\\sample_javadom_parser\\src\\sample_javadom_parser\\xmlfile.xml";
 
    public static void main(String argv[]) {
 
        try {
 
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
            Element root = document.createElement("company");
            document.appendChild(root);

            Element employee = document.createElement("employee");
 
            root.appendChild(employee);

            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            employee.setAttributeNode(attr);

            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("Alyssa"));
            employee.appendChild(firstName);

            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode("Laurence"));
            employee.appendChild(lastname);

            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("alyssalaurence@gmail.com"));
            employee.appendChild(email);
 
            Element department = document.createElement("department");
            department.appendChild(document.createTextNode("Bachelor of Science in Information Technology"));
            employee.appendChild(department);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}