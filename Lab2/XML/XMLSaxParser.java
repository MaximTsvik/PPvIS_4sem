package XML;

import Model.Student;
import Model.StudentBase;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class XMLSaxParser extends DefaultHandler {
    private Student student;
    private StudentBase studentBase;
    private List<Student> studentList;
    private String currentElement;
    private StringBuilder content;

    public XMLSaxParser() {
        studentList = new ArrayList<>();
        currentElement = "";
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("...End parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) {
        currentElement = qName;
        if (currentElement.equals("student")) {
            student = new Student();
            studentList.add(student);
            System.out.println("New student add!");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = new StringBuilder(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (currentElement.equals("surname")) {
            student.setSurname(content.toString());
            return;
        }
        if (currentElement.equals("name")) {
            student.setName(content.toString());
            return;
        }
        if (currentElement.equals("fatherName")) {
            student.setFatherName(content.toString());
            return;
        }
        if (currentElement.equals("adress")) {
            student.setAdress(content.toString());
            return;
        }
        if (currentElement.equals("family")) {
            student.setFamily(Integer.valueOf(content.toString()));
            return;
        }
        if (currentElement.equals("area")) {
            student.setArea(Double.valueOf(content.toString()));
            return;
        }
        if (currentElement.equals("perarea")) {
            student.setPerarea(Double.valueOf(content.toString()));
            return;
        }
        /*if (qName.equals("student")) {
            studentBase.setStudentsBase(studentList);
            System.out.println("Student add!");
        }*/
        if (currentElement.equals("student")) {
            studentBase.setStudentsBase(studentList);
            System.out.println("Student add!");}

        if (qName.equals("list")) {
            studentBase.setStudentsBase(studentList);
        }
    }

    public void setBase(StudentBase studentBase) {
        this.studentBase = studentBase;
    }

}
