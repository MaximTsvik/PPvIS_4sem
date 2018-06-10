package XML;

import Model.Student;
import Model.StudentBase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLDomParser {
    private File file;
    private Document document;
    private StudentBase studentBase;

    public void write(File file, StudentBase studentBase) {
        this.file = file;
        this.studentBase = studentBase;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element list = document.createElement("list");

            for (int numOfStudent = 0; numOfStudent < studentBase.getStudentsBase().size(); numOfStudent++) {
                Element student = document.createElement("student");
                student.setAttribute("id", numOfStudent + "");

                Element surname = document.createElement("surname");
                surname.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getSurname());
                student.appendChild(surname);

                Element name = document.createElement("name");
                name.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getName());
                student.appendChild(name);

                Element fatherName = document.createElement("fatherName");
                fatherName.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getFatherName());
                student.appendChild(fatherName);

                Element adress = document.createElement("adress");
                adress.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getAdress());
                student.appendChild(adress);

                Element family = document.createElement("family");
                family.setTextContent(String.valueOf(studentBase.getStudentsBase().get(numOfStudent).getFamily()));
                student.appendChild(family);

                Element area = document.createElement("area");
                area.setTextContent(String.valueOf(studentBase.getStudentsBase().get(numOfStudent).getArea()));
                student.appendChild(area);

                Element perarea = document.createElement("perarea");
                perarea.setTextContent(String.valueOf(studentBase.getStudentsBase().get(numOfStudent).getPerarea()));
                student.appendChild(perarea);

                list.appendChild(student);
            }

            document.appendChild(list);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException ex) {
            String exText = ex.getMessage();
            studentBase.getController().alertMessage(exText);
        } catch (TransformerConfigurationException ex) {
            String exText = ex.getMessage();
            studentBase.getController().alertMessage(exText);
        } catch (TransformerException ex) {
            String exText = ex.getMessage();
            studentBase.getController().alertMessage(exText);
        }
    }
}
