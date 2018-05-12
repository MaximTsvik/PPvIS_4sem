package sample;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StartStop {

    private Button start = new Button();
    private Button stop = new Button();

    public void startStartStop(GridPane root) {

        start.setText("Старт");
        stop.setText("Стоп");
        start.setPrefSize(100, 50);
        stop.setPrefSize(100, 50);

        root.getChildren().addAll(start, stop);

        root.setConstraints(start, 4, 0);
        root.setConstraints(stop, 5, 0);
    }
}
