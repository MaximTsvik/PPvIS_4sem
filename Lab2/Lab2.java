
import Controller.Controller;
import javafx.application.Application;

import javafx.stage.Stage;

public class Lab2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
