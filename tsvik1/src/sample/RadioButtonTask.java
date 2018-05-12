package sample;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RadioButtonTask {

    private TextField lineText = new TextField();
    private Button btn = new Button();
    private RadioButton radioBtn1 = new RadioButton("текст1");
    private RadioButton radioBtn2 = new RadioButton("текст2");
    private RadioButton radioBtn3 = new RadioButton("текст3");
    private ToggleGroup tg = new ToggleGroup();

    public void startRadioButtonTask(GridPane root) {
        lineText.setPromptText("Введите текст");
        btn.setText("Ввод");
        lineText.setPrefColumnCount(30);

        radioBtn1.setToggleGroup(tg);
        radioBtn2.setToggleGroup(tg);
        radioBtn3.setToggleGroup(tg);

        btn.setOnAction((event) -> {
            if ( lineText.getText().equals(radioBtn1.getText()) ) {
                radioBtn1.setSelected(true);
            }
            else if ( lineText.getText().equals(radioBtn2.getText()) ) {
                radioBtn2.setSelected(true);
            }
            else if ( lineText.getText().equals(radioBtn3.getText()) ) {
                radioBtn3.setSelected(true);
            }
            else {
                AlertError alert = new AlertError();
                alert.callAlertError("Такого текста не существует");
            }
        });

        root.setConstraints(lineText, 0, 0);
        root.setConstraints(btn, 1, 0);
        root.setConstraints(radioBtn1, 0, 1);
        root.setHalignment(radioBtn1, HPos.LEFT);
        root.setConstraints(radioBtn2, 0, 1);
        root.setHalignment(radioBtn2, HPos.CENTER);
        root.setConstraints(radioBtn3, 0, 1);
        root.setHalignment(radioBtn3, HPos.RIGHT);
        root.setVgap(8);
        root.setHgap(4);

        root.getChildren().addAll(lineText,btn,radioBtn1,radioBtn2,radioBtn3);
    }
}