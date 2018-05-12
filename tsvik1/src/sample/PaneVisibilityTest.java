import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/*import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class PaneVisibilityTest extends Application {

    private Pane mainPane;
    private Pane pane1;
    private Button showHide;

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(createContent());
        stage.setScene(scene);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        stage.setTitle("PaneVisibilityTest");
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setResizable(true);
        stage.show();
    }

    private Parent createContent() {
        initMain();
        initPane1();
        initShowHideButton();
        return mainPane;
    }

    private void initMain() {
        mainPane = new Pane();
        mainPane.setStyle("-fx-background-color: #add8e6");

        Label mainPaneText = new Label("Main Pane");
        mainPaneText.setLayoutX(200);
        mainPaneText.setLayoutY(40);
        mainPane.getChildren().add(mainPaneText);
    }

    private void initShowHideButton() {
        showHide = new Button("Show pane1");
        showHide.setOnAction(event -> {
            boolean isShowPane1 = isShow();
            pane1.setVisible(isShowPane1);
            pane1.setDisable(!isShowPane1);
            showHide.setText(isShowPane1 ? "Hide pane1" : "Show pane1");
        });
        mainPane.getChildren().add(showHide);
    }

    private boolean isShow() {
        return showHide.getText().equals("Show pane1");
    }

    private void initPane1() {
        pane1 = new Pane();
        pane1.setStyle("-fx-background-color: #ff93f9");
        pane1.setPrefSize(200, 200);
        pane1.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        pane1.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        pane1.setVisible(false);
        pane1.setDisable(false);
        pane1.setLayoutX(100);
        pane1.setLayoutY(100);
        Label pane1Text = new Label("Pane1 Text");
        pane1Text.setLayoutX(40);
        pane1Text.setLayoutY(40);
        pane1.getChildren().add(pane1Text);
        mainPane.getChildren().add(pane1);
    }

    root.getChildren().addAll(start, stop);
}*/