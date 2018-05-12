package sample;

import java.awt.*;
import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class ComboBoxTask {

    private ComboBox<String> box = new ComboBox<>();
    private ArrayList<String> textBox = new ArrayList<>();
    private TextField lineText = new TextField();
    private Button btn = new Button();
    private boolean visible;

    public void startComboBoxTask(GridPane root) {

        lineText.setPromptText("Выберите вариант");
        btn.setText("Ввод");
        lineText.setPrefColumnCount(30);

        btn.setOnAction((event) -> {
            String text = lineText.getText();
            if(!textBox.contains(text)) {
                textBox.add(text);
                box.getItems().add(text);
            }
            else {
                AlertError alert = new AlertError();
                alert.callAlertError("Такой текст уже существует!!");
            }
        });

        root.setConstraints(lineText, 0, 0);
        root.setConstraints(btn, 1, 0);
        root.setConstraints(box, 0, 1);
        root.setHalignment(box, HPos.LEFT);

        root.getChildren().addAll(lineText,btn,box);

    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}