package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableColumn;

public class TableWidgetTask {

    private TextField lineText = new TextField();
    private Button btn1 = new Button();
    private Button btn2 = new Button();
    private Button btn3 = new Button();

    private ObservableList<ClassForTableWrapper>  allClass = FXCollections.observableArrayList();

    private TableView<ClassForTableWrapper> table;

    public void createTableBox () {
        table = new TableView<>();
        TableColumn firstColumn = new TableColumn("Первая колонка");
        firstColumn.setCellValueFactory(new PropertyValueFactory<ClassForTable, String>("str1"));
        firstColumn.setMinWidth(200);
        TableColumn secondColumn = new TableColumn("Вторая колонка");
        secondColumn.setCellValueFactory(new PropertyValueFactory<ClassForTable, String>("str2"));
        secondColumn.setMinWidth(200);

        table.setItems(allClass);
        table.getColumns().addAll(firstColumn,secondColumn);
    }

    public void startTableWidgetTask (GridPane root) {

        lineText.setPromptText("Введите текст");
        btn1.setText("Ввод");
        btn2.setText("Вправо");
        btn3.setText("Влево");

        createTableBox();

        btn1.setOnAction((event) -> {
            ClassForTable cls = new ClassForTable(lineText.getText(), "");
            allClass.add(new ClassForTableWrapper(cls));
        });

        btn2.setOnAction((event) -> {
            ObservableList<ClassForTableWrapper> selectedItem = table.getSelectionModel().getSelectedItems();
            try {
                if (!table.getSelectionModel().getSelectedItems().equals(""))
                {
                    allClass.set(allClass.indexOf(selectedItem.get(0)), new ClassForTableWrapper(new ClassForTable("",selectedItem.get(0).getStr1())));
                }
            }
            catch (Exception ex) {
                        AlertError alert = new AlertError();
                        alert.callAlertError("Выберите ячейку!!");
                    }
            });

        btn3.setOnAction((event) -> {
            ObservableList<ClassForTableWrapper> selectedItem = table.getSelectionModel().getSelectedItems();
            try {
                if (!table.getSelectionModel().getSelectedItems().equals(""))
                {
                    allClass.set(allClass.indexOf(selectedItem.get(0)), new ClassForTableWrapper(new ClassForTable(selectedItem.get(0).getStr2(),"")));
                }
            }
            catch (Exception ex) {
                AlertError alert = new AlertError();
                alert.callAlertError("Выберите ячейку!!");
            }

        });

        root.setConstraints(lineText, 0, 16);
        root.setConstraints(btn1, 1, 16);
        root.setConstraints(btn2, 0, 17);
        root.setHalignment(btn2, HPos.LEFT);
        root.setConstraints(btn3, 0, 17);
        root.setHalignment(btn3, HPos.RIGHT);
        root.setConstraints(table, 0, 18);

       root.getChildren().addAll(lineText,btn1,btn2,btn3,table);
    }
}
