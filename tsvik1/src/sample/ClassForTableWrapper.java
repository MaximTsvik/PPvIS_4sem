package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassForTableWrapper {

    StringProperty str1;
    StringProperty str2;
    ClassForTable classForTable;

    public ClassForTableWrapper(ClassForTable cft) {
        this.classForTable = cft;
        this.str1 = new SimpleStringProperty(cft.getStr1());
        this.str2 = new SimpleStringProperty(cft.getStr2());
    }

    public String getStr1() {
        return str1.get();
    }

    public String getStr2() {
        return str2.get();
    }

    public ClassForTable getClassForTable() {
        return classForTable;
    }
}
