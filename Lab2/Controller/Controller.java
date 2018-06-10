package Controller;

import Model.Student;
import Model.StudentBase;
import View.MainFrame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private MainFrame mainFrame;
    private StudentBase studentBase;

    public Controller() {
        studentBase = new StudentBase(this);
        mainFrame = new MainFrame(this);
    }

    public void addStudent(Student student) {
        studentBase.add(student);
    }

    public void setStudentBase(StudentBase studentBase) {
        this.studentBase = studentBase;
    }

    public List<Student> getStudentBase() {
        return studentBase.getStudentsBase();
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setFile(File file){
        studentBase.setFile(file);
    }

    public File getFile(){
        return studentBase.getFile();
    }

    public void toFile(File file){
        studentBase.toFile(file);
    }

    public void fromFile(){
        studentBase.fromFile();
        mainFrame.update();
    }

    public List<Student> searchStudents (Student searchStudent, String paramSearch) {
        List<Student> searchStud = new ArrayList<>();
        List<Student> allStudents = getStudentBase();

       if (paramSearch.equals("Family")) {
            for (Student stud : allStudents) {
                if (stud.getSurname().equals(searchStudent.getSurname())
                        && (stud.getFamily() == (searchStudent.getFamily()))) {
                    searchStud.add(stud);
                }
            }
        }

        else if (paramSearch.equals("Area")) {
            for (Student stud : allStudents) {
                if (stud.getFamily() == (searchStudent.getFamily())
                    && (stud.getArea() > (searchStudent.getMinArea()))
                    && (stud.getArea() < (searchStudent.getMaxArea())));
                {
                    searchStud.add(stud);
                }
            }
        }

       else if (paramSearch.equals("Surname")) {
            for (Student stud : allStudents) {
                if (stud.getSurname().equals(searchStudent.getSurname())
                        && (stud.getArea() == (searchStudent.getArea()))) {
                    searchStud.add(stud);
                }
            }
        }

       else if (paramSearch.equals("Perarea")) {
           for (Student stud : allStudents) {
               if ((stud.getPerarea() >= (searchStudent.getPerarea())))
               {
                   searchStud.add(stud);
               }
           }
       }

        return searchStud;
    }

    public void alertMessage(String text){
        mainFrame.alertMessage(text);
    }
}
