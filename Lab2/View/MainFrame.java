package View;

import Controller.Controller;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static javafx.geometry.Orientation.*;
import static javax.swing.SwingConstants.VERTICAL;

public class MainFrame {
    private Controller controller;
    private Form form;

    public MainFrame(Controller controller) {
        this.controller = controller;

        ToolBar tb = new ToolBar();
        tb.cursorProperty();
        Button load = new Button("Загрузка");
        load.setOnAction( e -> {
            controller.getStudentBase().clear();
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открытие");
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });
        Button save = new Button("Сохранение");
        save.setOnAction( e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);

            controller.toFile(file);
        });
        Button add = new Button("Добавление");
        add.setOnAction( e -> {
            AddFrame addFrame = new AddFrame(this, this.controller);
        });
        Button search = new Button("Поиск");
        search.setOnAction( e -> {
            SearchFrame searchFrame = new SearchFrame(this, this.controller);
            searchFrame.start();
        });
        Button delete = new Button("Удаление");
        delete.setOnAction( e -> {
            DeleteFrame deleteFrame = new DeleteFrame(this, this.controller);
            deleteFrame.start();
        });
        tb.getItems().addAll(load, save, add, search, delete);
        tb.setOrientation(Orientation.HORIZONTAL);

        MenuBar menuBar = new MenuBar();
        Menu menuF = new Menu("Файл");
        MenuItem menuItemP = new MenuItem("Загрузка");
        menuItemP.setOnAction(e -> {
            controller.getStudentBase().clear();
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Открытие");
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            controller.setFile(file);
            controller.fromFile();
            update();
        });
        MenuItem menuItemS = new MenuItem("Сохранение");
        menuItemS.setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new java.io.File("./"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showSaveDialog(stage);

            controller.toFile(file);
        });
        menuF.getItems().addAll(menuItemP, menuItemS);

        Menu menuT = new Menu("Таблица");
        MenuItem menuAdd = new MenuItem("Добавление");
        MenuItem menuSearch = new MenuItem("Поиск");
        MenuItem menuDelete = new MenuItem("Удаление");
        menuT.getItems().addAll(menuAdd, menuSearch, menuDelete);

        menuBar.getMenus().addAll(menuF, menuT);

        menuAdd.setOnAction(e -> {
            System.out.println("Добавилось ура!");
            AddFrame addFrame = new AddFrame(this, this.controller);
        });

        menuSearch.setOnAction(e -> {
            System.out.println("Нашлось ура!");
            SearchFrame searchFrame = new SearchFrame(this, this.controller);
            searchFrame.start();
        });

        menuDelete.setOnAction(e -> {
            System.out.println("Удалилось ура!");
            DeleteFrame deleteFrame = new DeleteFrame(this, this.controller);
            deleteFrame.start();
        });

        form = new Form();
        form.setList(controller.getStudentBase());

        VBox menushka = new VBox();
        menushka.setPadding(new Insets(50, 100, 30, 10));
        menushka.setSpacing(20);

        HBox collectiveMemberBox = new HBox();
        collectiveMemberBox.setSpacing(20);
        collectiveMemberBox.getChildren().addAll(form.getPaneBox());
        menushka.getChildren().addAll(tb, collectiveMemberBox);

        Scene scene = new Scene(new Group(), 1700, 700);
        ((Group) scene.getRoot()).getChildren().addAll(menushka, menuBar);

        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tsvik_2lab");
        primaryStage.show();
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void update() {
        form.clear();
        form.setList(controller.getStudentBase());
        form.getStudentTable().setItems(FXCollections.observableArrayList(controller.getStudentBase()));
    }


    public void alertMessage(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
