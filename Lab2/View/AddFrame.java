package View;

import Controller.Controller;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddFrame {
    private MainFrame mainFrame;
    private Controller controller;

    public AddFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;


        GridPane pane=new GridPane();
        pane.setPadding(new Insets(15));
        pane.setVgap(15);
        pane.setHgap(15);

        pane.add(new Label("Student"),0,0);
        pane.add(new Label("Surname"),0,1);
        pane.add(new Label("Name"),0,2);
        pane.add(new Label("Fathername"),0,3);
        pane.add(new Label("Adress"), 0,4);
        pane.add(new Label("Family"), 0,5);
        pane.add(new Label("Area"), 0,6);
        pane.add(new Label("Perarea"), 0,7);

        TextField surnameField = new TextField();
        surnameField.setPromptText("Surname");
        pane.add(surnameField,1,1);

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        pane.add(nameField,1,2);

        TextField fatherNameField = new TextField();
        fatherNameField.setPromptText("Fathername");
        pane.add(fatherNameField,1,3);

        TextField adressField = new TextField();
        adressField.setPromptText("Adress");
        pane.add(adressField,1,4);

        TextField familyField = new TextField();
        familyField.setPromptText("Family");
        pane.add(familyField,1,5);

        TextField areaField = new TextField();
        areaField.setPromptText("Area");
        pane.add(areaField,1,6);

        TextField perareaField = new TextField();
        perareaField.setPromptText("Perarea");
        pane.add(perareaField,1,7);

        Button addStudentButton=new Button("Add student");
        addStudentButton.setOnAction(e -> {
            Student student = new Student();
            student.setFullName(surnameField.getText(),nameField.getText(),fatherNameField.getText());
            student.setAdress(adressField.getText());
            student.setFamily(Integer.valueOf(familyField.getText()));
            student.setArea(Double.valueOf(areaField.getText()));
            student.setPerarea(Double.valueOf(perareaField.getText()));

            controller.addStudent(student);

            surnameField.clear();
            nameField.clear();
            fatherNameField.clear();
            adressField.clear();
            familyField.clear();
            areaField.clear();
            perareaField.clear();

            mainFrame.update();
        });


        pane.add(addStudentButton,2,0);

        Scene scene = new Scene(pane);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add new student");

        stage.show();
    }

    public void alertMessage(String text) {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.showAndWait();
    }

}