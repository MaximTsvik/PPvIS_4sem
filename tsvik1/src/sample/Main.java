package sample;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.*;
import javafx.stage.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.sun.glass.ui.Cursor.setVisible;

public class Main extends Application {

    private int loop = 0;
    private Button start = new Button();
    private Button stop = new Button();

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
       root.setPadding(new Insets(25, 25, 10, 10));

        GridPane pane1 = new GridPane();
       // pane1.setAlignment(Pos.BASELINE_LEFT);
        pane1.setHgap(5);
        pane1.setVgap(5);
       pane1.setPadding(new Insets(10, 10, 10, 10));

        GridPane pane2 = new GridPane();
       // pane2.setAlignment(Pos.BASELINE_RIGHT);
        pane2.setHgap(5);
        pane2.setVgap(5);
        pane2.setPadding(new Insets(10, 10, 10, 10));

        GridPane pane3 = new GridPane();
       // pane3.setAlignment(Pos.BASELINE_LEFT);
        pane3.setHgap(5);
        pane3.setVgap(5);
        pane3.setPadding(new Insets(10, 10, 10, 10));

        GridPane pane4 = new GridPane();
       // pane4.setAlignment(Pos.BASELINE_RIGHT);
        pane4.setHgap(5);
        pane4.setVgap(5);
        pane4.setPadding(new Insets(10, 10, 10, 10));

        GridPane pane5 = new GridPane();
      //  pane5.setAlignment(Pos.CENTER);
        pane5.setHgap(5);
        pane5.setVgap(5);
        pane5.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setTitle("Лаба1");
        primaryStage.setScene(scene);

        ComboBoxTask comboBox = new ComboBoxTask();
        comboBox.startComboBoxTask(pane1);

        //root.setVisible(false);

        SwapTask swap = new SwapTask();
        swap.startSwapTask(pane2);

        RadioButtonTask radioButton = new RadioButtonTask();
        radioButton.startRadioButtonTask(pane3);

        CheckBoxTask checkBoxTask = new CheckBoxTask();
        checkBoxTask.startCheckBoxTask(pane4);

        TableWidgetTask tableWidgetTask = new TableWidgetTask();
        tableWidgetTask.startTableWidgetTask(pane5);

        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(false);
        pane5.setVisible(false);

        ObservableList<GridPane> panes = FXCollections.observableArrayList();
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (loop != -1){
                        panes.get(loop).setVisible(!panes.get(loop).isVisible());
                    //panes.get(loop).setVisible(true);
                    loop = (loop + 1) % panes.size();
                    System.out.print(loop);
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        start.setOnAction(ActionEvent -> {
            th.start();
        });
        stop.setOnAction(event -> {
            loop = -1;
        });

        panes.addAll(pane1, pane2, pane3, pane4, pane5);

        start.setText("Старт");
        stop.setText("Стоп");
        start.setPrefSize(100, 50);
        stop.setPrefSize(100, 50);

        root.getChildren().addAll(start, stop, pane1, pane2, pane3, pane4, pane5);

        root.setConstraints(pane1, 0, 0);
        root.setConstraints(pane2, 0, 1);
        root.setConstraints(pane3, 0, 2);
        root.setConstraints(pane4, 0, 3);
        root.setConstraints(pane5, 0, 4);
        root.setConstraints(start, 1, 0);
        root.setConstraints(stop, 2, 0);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}