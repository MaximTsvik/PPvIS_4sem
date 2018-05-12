package sample;

import javafx.scene.control.Alert;

public class AlertError {
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public void callAlertError(String typeOfError) {
        alert.setTitle("Ошибка");
        alert.setHeaderText(typeOfError);
        alert.setContentText("Введите другой текст!");

        alert.showAndWait();
    }
}
