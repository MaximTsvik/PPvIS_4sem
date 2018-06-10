package View;


import Model.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;


public class Form {

    private TableView<Student> studentTable;
    private VBox paneBox;
    private int currentPage = 0;
    private int recordsOnPage = 10;
    private List<Student> list;
    private Label allRecordsLabel;
    private Label allPageLabel;


    public Form() {
        studentTable = new TableView<>();

        List<TableColumn> listOfColumns = new ArrayList<>();

        TableColumn<Student,String> fullNameColumn = new TableColumn<>("ФИО студента");
        fullNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().FIO()));
        fullNameColumn.setMinWidth(300);

        TableColumn<Student,String> studentAdress = new TableColumn<>("Адрес");
        studentAdress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        studentAdress.setMinWidth(200);

        TableColumn<Student,String> studentFamily = new TableColumn<>("Кол-во членов семьи");
        studentFamily.setCellValueFactory(new PropertyValueFactory<>("family"));
        studentFamily.setMinWidth(200);

        TableColumn<Student,String> studentArea = new TableColumn<>("Общая площадь");
        studentArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        studentArea.setMinWidth(200);

        TableColumn<Student,String> studentPerarea = new TableColumn<>("Площадь на человека");
        studentPerarea.setCellValueFactory(new PropertyValueFactory<>("perarea"));
        studentPerarea.setMinWidth(200);

        studentTable.setPrefSize(1400,500);

        studentTable.getColumns().addAll(fullNameColumn, studentAdress, studentFamily, studentArea, studentPerarea);

        paneBox = new VBox(20);

        HBox pageBox = new HBox(20);

        Label currentPageLabel = new Label("Текущая страница: "+ (currentPage+1));

        allPageLabel = new Label("Кол-во страниц: " + 0);
        allRecordsLabel = new Label();
        Label recordOnPages = new Label("Кол-во записей на странице: " + recordsOnPage);

        Button firstPage = new Button("Первая страница");
        firstPage.setOnAction(e-> {
            currentPage = 0;
            setCurrentPage(currentPage);
            currentPageLabel.setText("Текущая страница: "+ (currentPage+1));
        });

        Button previousPage = new Button("Предыдущая страница");
        previousPage.setOnAction(e -> {
            if(currentPage>0){
                currentPage--;
                setCurrentPage(currentPage);
                currentPageLabel.setText("Такущая страница: "+ (currentPage+1));
            }
        });

        Button nextPage = new Button("Следующая страница");
        nextPage.setOnAction(e -> {
            if(currentPage<(list.size()-1)/recordsOnPage){
                currentPage++;
                setCurrentPage(currentPage);
                currentPageLabel.setText("Текущая страница: "+ (currentPage+1));
            }
        });

        Button lastPage = new Button("Последняя страница");
        lastPage.setOnAction(e -> {
            currentPage=(list.size()-1)/recordsOnPage;
            setCurrentPage(currentPage);
            currentPageLabel.setText("Текущая страница: "+ (currentPage+1));
        });


        TextField recordOnPagesField = new TextField();
        recordOnPagesField.setPromptText("Кол-во записей на странице: ");
        Button enterRecord = new Button("OK");
        enterRecord.setOnAction(e -> {
            int records = Integer.parseInt(recordOnPagesField.getText());
            recordsOnPage=records;
            recordOnPages.setText("Кол-во записей на странице: " + recordsOnPage);
            currentPage=0;
            setCurrentPage(currentPage);
            currentPageLabel.setText("Текущая страница: "+(currentPage+1));
            recordOnPagesField.clear();
            allPageLabel.setText("Кол-во страниц: " + (int)Math.ceil((double)list.size()/recordsOnPage));

        });
        pageBox.getChildren().addAll(firstPage, previousPage, nextPage, lastPage, currentPageLabel, allPageLabel,
                allRecordsLabel, recordOnPages, recordOnPagesField, enterRecord);

        paneBox.getChildren().addAll(studentTable, pageBox);
        paneBox.setSpacing(3);

    }

    public VBox getPaneBox() {
        return paneBox;
    }

    public TableView<Student> getStudentTable() {
        return studentTable;
    }

    public void setPaneBox(VBox paneBox) {
        this.paneBox = paneBox;
    }

    public void setStudentTable(TableView<Student> studentTable) {
        this.studentTable = studentTable;
    }

    public void clear() {
        ObservableList<Student> list = FXCollections.observableArrayList();
        studentTable.setItems(list);
    }

    public void setList(List<Student> studentList)
    {
        this.list = studentList;
        allRecordsLabel.setText("Кол-во записей: " + studentList.size());
        allPageLabel.setText("Кол-во страниц: " + (int)Math.ceil((double)list.size()/recordsOnPage));
    }

    public void setCurrentPage(int currentPage) {
        List<Student> page = new ArrayList<>();
        int numberOfRecords = recordsOnPage;
        if((list.size()-currentPage*recordsOnPage)<recordsOnPage) {
            numberOfRecords = this.list.size()-currentPage*recordsOnPage;
        }

        for (int stud=currentPage*recordsOnPage;stud<currentPage*recordsOnPage+numberOfRecords;stud++){
            page.add(this.list.get(stud));
        }
        clear();
        studentTable.setItems(FXCollections.observableArrayList(page));
    }
}
