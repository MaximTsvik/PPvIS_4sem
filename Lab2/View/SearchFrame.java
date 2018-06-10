package View;

import Controller.Controller;
import Model.Student;
import Model.StudentBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SearchFrame {
    private MainFrame mainFrame;
    private Student searchStudent = new Student();
    private Controller controller;
    private TabPane tp;
    private List<Button> buttons = new ArrayList<>();
    private TextField surnameFieldFamily1;
    private TextField surnameFieldFamily2;
    private TextField areaFieldFamily1;
    private TextField areaFieldFamily2;
    private TextField areaMinField;
    private TextField areaMaxField;
    private TextField surnameFieldArea1;
    private TextField surnameFieldArea2;
    private TextField perareaField;
    private Form familyForm;
    private Form areaForm;
    private Form surnameForm;
    private Form perareaForm;
    private VBox rootFamily;
    private VBox rootArea;
    private VBox rootSurname;
    private VBox rootPerarea;


    public SearchFrame(MainFrame mainFrame, Controller controller) {
        this.mainFrame = mainFrame;
        this.controller = controller;
    }

    public void start () {
        Group root = new Group();
        setTabPane("Search");
        root.getChildren().addAll(getTabPane());
        setForm();
        setActionOnButtons();
        Scene scene = new Scene(root, 1200, 680);
        Stage stage = new Stage();
        stage.setTitle("Search students");
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void setActionOnButtons () {

        buttons.get(0).setOnAction(e -> {
            searchStudent.setSurname(surnameFieldFamily1.getText());
            searchStudent.setFamily(Integer.valueOf(surnameFieldFamily2.getText()));
            List<Student> resultOfSearch = controller.searchStudents(searchStudent, "Family");
            familyForm.setList(resultOfSearch);
            familyForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            searchStudent.clean();
            alertMessage(resultOfSearch, " searched");
        });

        buttons.get(1).setOnAction(e -> {
            searchStudent.setFamily(Integer.valueOf(areaFieldFamily2.getText()));
            searchStudent.setMinArea(Double.valueOf(areaMinField.getText()));
            searchStudent.setMaxArea(Double.valueOf(areaMaxField.getText()));
            List<Student> resultOfSearch = controller.searchStudents(searchStudent, "Area");
            areaForm.setList(resultOfSearch);
            areaForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            searchStudent.clean();
            alertMessage(resultOfSearch, " searched");
        });

        buttons.get(2).setOnAction(e -> {
            searchStudent.setArea((Double.valueOf(surnameFieldArea2.getText())));
            searchStudent.setSurname(surnameFieldArea1.getText());
            List<Student> resultOfSearch = controller.searchStudents(searchStudent, "Surname");
            surnameForm.setList(resultOfSearch);
            surnameForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            searchStudent.clean();
            alertMessage(resultOfSearch, " searched");
        });

        buttons.get(3).setOnAction(e -> {
            searchStudent.setPerarea(Double.valueOf(perareaField.getText()));
            List<Student> resultOfSearch = controller.searchStudents(searchStudent, "Perarea");
            perareaForm.setList(resultOfSearch);
            perareaForm.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
            searchStudent.clean();
            alertMessage(resultOfSearch, " searched");
        });
    }

    public void alertMessage(List<Student> list, String str) {
            if (list.size() != 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(list.size() + str + " students");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No such students");
            alert.showAndWait();
        }
    }

    public void setTabPane(String search) {
        tp = new TabPane();
        tp.setLayoutX(3);
        tp.setLayoutY(7);

        Tab tabFamily = new Tab(search +" Surname and Family ");
        rootFamily = new VBox();
        tabFamily.setContent(rootFamily);
        GridPane familyBox = new GridPane();
        familyBox.setPadding(new Insets(15));
        familyBox.setVgap(15);
        familyBox.setHgap(15);

        Label surnameLabelFamily1 = new Label("Surname ");
        surnameFieldFamily1 = new TextField();
        surnameFieldFamily1.setPromptText("Surname");
        familyBox.add(surnameLabelFamily1, 0, 0);
        familyBox.add(surnameFieldFamily1, 1, 0);

        Label surnameLabelFamily2 = new Label("Family ");
        surnameFieldFamily2 = new TextField();
        surnameFieldFamily2.setPromptText("Family");
        familyBox.add(surnameLabelFamily2, 0, 1);
        familyBox.add(surnameFieldFamily2, 1, 1);

        Button familyButton = new Button(search);

        familyBox.add(familyButton, 2, 0);

        rootFamily.getChildren().addAll(familyBox);





        Tab tabArea = new Tab(search + " Area and Family ");
        rootArea = new VBox();
        tabArea.setContent(rootArea);
        GridPane areaBox = new GridPane();
        areaBox.setPadding(new Insets(15));
        areaBox.setVgap(15);
        areaBox.setHgap(15);

        Label areaLabelFamily2 = new Label("Family  ");
        areaFieldFamily2 = new TextField();
        areaFieldFamily2.setPromptText("Family");
        areaBox.add(areaLabelFamily2, 0, 1);
        areaBox.add(areaFieldFamily2, 1, 1);

        Label areaLabelFamily1 = new Label("Area");
        areaMinField = new TextField();
        areaMinField.setPromptText("Min number area");
        areaBox.add(areaMinField, 1, 2);
        areaMaxField = new TextField();
        areaMaxField.setPromptText("Max number area");
        areaBox.add(areaMaxField, 2, 2);
        areaBox.add(areaLabelFamily1, 0, 2);


        Button areaButton = new Button(search);

        areaBox.add(areaButton, 2, 0);

        rootArea.getChildren().addAll(areaBox);



        Tab tabSurname = new Tab(search + " Surname and Area ");
        rootSurname = new VBox();
        GridPane surnameBox = new GridPane();
        tabSurname.setContent(rootSurname);
        surnameBox.setPadding(new Insets(15));
        surnameBox.setVgap(15);
        surnameBox.setHgap(15);

        Label surnameLabelArea1 = new Label("Surname");
        surnameFieldArea1 = new TextField();
        surnameFieldArea1.setPromptText("Surname");
        surnameBox.add(surnameLabelArea1, 0, 0);
        surnameBox.add(surnameFieldArea1, 1, 0);

        Label surnameLabelArea2 = new Label("Area");
        surnameFieldArea2 = new TextField();
        surnameFieldArea2.setPromptText("Area");
        surnameBox.add(surnameLabelArea2, 0, 1);
        surnameBox.add(surnameFieldArea2, 1, 1);

        Button surnameButton = new Button(search);

        surnameBox.add(surnameButton, 2, 0);

        rootSurname.getChildren().addAll(surnameBox);


        Tab tabPrearea = new Tab(search +" more than perarea");
        rootPerarea = new VBox();
        tabPrearea.setContent(rootPerarea);
        GridPane preareaBox = new GridPane();
        preareaBox.setPadding(new Insets(15));
        preareaBox.setVgap(15);
        preareaBox.setHgap(15);

        Label preareaLabel = new Label("Prearea");
        perareaField = new TextField();
        perareaField.setPromptText("Prearea");
        preareaBox.add(preareaLabel, 0, 1);
        preareaBox.add(perareaField, 1, 1);

        Button perareaButton = new Button(search);

        preareaBox.add(perareaButton, 2, 0);

        rootPerarea.getChildren().addAll(preareaBox);

        buttons.add(familyButton);
        buttons.add(areaButton);
        buttons.add(surnameButton);
        buttons.add(perareaButton);
        tp.getTabs().addAll(tabFamily, tabArea, tabSurname, tabPrearea);
    }

    public void setForm () {
        familyForm = new Form();
        rootFamily.getChildren().add(familyForm.getPaneBox());

        areaForm = new Form();
        rootArea.getChildren().add(areaForm.getPaneBox());

        surnameForm = new Form();
        rootSurname.getChildren().add(surnameForm.getPaneBox());

        perareaForm = new Form();
        rootPerarea.getChildren().add(perareaForm.getPaneBox());
    }

    public TabPane getTabPane() {
        return tp;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public Student getSearchStudent() {
        return searchStudent;
    }

    public Controller getController() {
        return controller;
    }

    public TextField getSurnameFieldFamily1() {
        return surnameFieldFamily1;
    }

    public TextField getSurnameFieldFamily2() {
        return surnameFieldFamily2;
    }

    public TextField getAreaFieldFamily1() {
        return areaFieldFamily1;
    }

    public TextField getAreaFieldFamily2() {
        return areaFieldFamily2;
    }

    public TextField getAreaMinField() {
        return areaMinField;
    }

    public TextField getAreaMaxField() {
        return areaMaxField;
    }

    public TextField getSurnameFieldArea1() {
        return surnameFieldArea1;
    }

    public TextField getSurnameFieldArea2() {
        return surnameFieldArea2;
    }

    public TextField getPerareaField() {
        return perareaField;
    }

    public Form getAreaForm() {
        return areaForm;
    }

    public Form getPerareaForm() {
        return perareaForm;
    }

    public Form getFamilyForm() {
        return familyForm;
    }

    public Form getSurnameForm() {
        return surnameForm;
    }
}
