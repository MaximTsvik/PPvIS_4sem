package sample;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SwapTask {

    private TextField lineText = new TextField();
    private Button btn1 = new Button();
    private Button btn2 = new Button();

    public void startSwapTask(GridPane root) {

        lineText.setPrefColumnCount(34);
        lineText.setPromptText("Введите текст");

        btn1.setText("Ввод");
        btn2.setText("Ввод");

        btn1.setOnAction((event) -> btn2.setText(lineText.getText()));

        btn2.setOnAction((event) -> {
            String textFromButton = btn1.getText();
            btn1.setText(btn2.getText());
            btn2.setText(textFromButton);
        });

        root.setConstraints(lineText, 0, 0);
        root.setConstraints(btn1, 0, 1);
        root.setHalignment(btn1, HPos.LEFT);
        root.setConstraints(btn2, 0, 1);
        root.setHalignment(btn2, HPos.RIGHT);

      root.getChildren().addAll(lineText,btn1,btn2);
    }
}
