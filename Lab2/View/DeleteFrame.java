package View;

import Controller.Controller;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class DeleteFrame extends SearchFrame {

    public DeleteFrame (MainFrame mainFrame, Controller controller){
        super(mainFrame, controller);
    }

    @Override
    public void start () {
        Group root = new Group();
        setTabPane("Delete");
        root.getChildren().addAll(getTabPane());
        setActionOnButtons();
        Scene scene = new Scene(root, 670, 200);
        Stage stage = new Stage();
        stage.setTitle("Delete students");
        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void setActionOnButtons() {
        getButtons().get(0).setOnAction(e -> {
            getSearchStudent().setSurname(getSurnameFieldFamily1().getText());
            getSearchStudent().setFamily(Integer.valueOf(getSurnameFieldFamily2().getText()));
            List<Student> resultOfSearch = getController().searchStudents(getSearchStudent(), "Family");
            getController().getStudentBase().removeAll(resultOfSearch);
            getMainFrame().update();
            getSearchStudent().clean();
            alertMessage(resultOfSearch, " deleted");
        });

        getButtons().get(1).setOnAction(e -> {
            getSearchStudent().setArea(Double.valueOf(getAreaMinField().getText()));
            getSearchStudent().setFamily(Integer.valueOf(getAreaFieldFamily2().getText()));
            List<Student> resultOfSearch = getController().searchStudents(getSearchStudent(), "Area");
            getController().getStudentBase().removeAll(resultOfSearch);
            getMainFrame().update();
            getSearchStudent().clean();
            alertMessage(resultOfSearch, " deleted");
        });

        getButtons().get(2).setOnAction(e -> {
            getSearchStudent().setArea(Double.valueOf(getSurnameFieldArea2().getText()));
            getSearchStudent().setSurname(getSurnameFieldArea1().getText());
            List<Student> resultOfSearch = getController().searchStudents(getSearchStudent(), "Surname");
            getController().getStudentBase().removeAll(resultOfSearch);
            getMainFrame().update();
            getSearchStudent().clean();
            alertMessage(resultOfSearch, " deleted");
        });

        getButtons().get(3).setOnAction(e -> {
            getSearchStudent().setPerarea(Double.valueOf(getPerareaField().getText()));
            List<Student> resultOfSearch = getController().searchStudents(getSearchStudent(), "Perarea");
            getController().getStudentBase().removeAll(resultOfSearch);
            getMainFrame().update();
            getSearchStudent().clean();
            alertMessage(resultOfSearch, " deleted");
        });
    }
}


