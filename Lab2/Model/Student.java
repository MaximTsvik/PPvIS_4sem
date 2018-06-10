package Model;


import java.util.ArrayList;
import java.util.List;


public class Student {

    private String surname;
    private String name;
    private String fatherName;
    private String city;
    private String street;
    private String house;
    private String adress;
    private int family;
    private double area;
    private double perarea;

    public Student() {
        surname = "";
        name = "";
        fatherName = "";
        city = "";
        street = "";
        house = "";
        adress = "";
        family = 0;
        area = 0.0;
        perarea = 0.0;

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    //@Override
    public String FIO() {
        return surname + " " +
                name + " " +
                fatherName;
    }

    /*public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String Adress() {
        return city + " " +
                street + " " +
                house;
    }*/

    public void setFamily(int family) {
        this.family = family;
    }

    public int getFamily() {
        return family;
    }

    public void setMinArea(double area) {
        this.area = area;
    }

    public double getMinArea()  {
        return area;
    };

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setMaxArea(double area) {
        this.area = area;
    }

    public double getMaxArea()  {
        return area;
    };

    public void setPerarea(double perarea) {
        this.perarea = perarea;
    }

    public double getPerarea() {
        return perarea;
    }

    /*public int getIntArea (String area){
        for (Student stud : allStudents) {
            int IntArea = Integer.valueOf()
        }
    }*/

    public void setFullName(String surname, String name, String fatherName) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
    }

   /*public boolean equalsNumberOfArea(int minNumber, int maxNumber) {
        for (Student stud : allStudents) {
            if (    area.getNumberArea() >= minNumber &&
                    area.getNumberArea() <= maxNumber) {
                return true;
            }
        }
        return false;
    }*/

    public void clean() {
        surname = "";
        name = "";
        fatherName = "";
        adress = "";
        family = 0;
        area = 0.0;
        perarea = 0.0;
    }
}
