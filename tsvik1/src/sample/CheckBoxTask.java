package sample;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CheckBoxTask {

    private TextField lineText = new TextField();
    private Button btn = new Button();
    private CheckBox checkBox1 = new CheckBox("текст1");
    private CheckBox checkBox2 = new CheckBox("текст2");
    private CheckBox checkBox3 = new CheckBox("текст3");

    public void startCheckBoxTask(GridPane root) {

        lineText.setPrefColumnCount(30);
        lineText.setPromptText("Введите текст");
        btn.setText("Ввод");


        btn.setOnAction((event) -> {
            if (lineText.getText().equals(checkBox1.getText())) {
                checkBox1.setSelected(!checkBox1.isSelected());
            }
            if (lineText.getText().equals(checkBox2.getText())) {
                checkBox2.setSelected(!checkBox2.isSelected());

            }
            if (lineText.getText().equals(checkBox3.getText())) {
                checkBox3.setSelected(!checkBox3.isSelected());

            }
        });

       root.getChildren().addAll(lineText, btn, checkBox1, checkBox2, checkBox3);

        root.setConstraints(lineText, 0, 0);
        root.setConstraints(btn, 1, 0);
        root.setConstraints(checkBox1, 0, 1);
        root.setHalignment(checkBox1, HPos.LEFT);
        root.setConstraints(checkBox2, 0, 1);
        root.setHalignment(checkBox2, HPos.CENTER);
        root.setConstraints(checkBox3, 0, 1);
        root.setHalignment(checkBox3, HPos.RIGHT);

    }
}
