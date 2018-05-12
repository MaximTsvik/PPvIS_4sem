package sample;

import java.io.Serializable;

public class ClassForTable implements Serializable {

    private String str1;
    private String str2;

    public ClassForTable(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String getStr1() { return str1; }

    public String getStr2() { return str2; }
}
