package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ToDoController {

    private ListModel model = new ListModel();

    @FXML
    private TableView<TaskModel> tvTasks;

    @FXML
    private TableColumn<TaskModel, Boolean> tcComplete;

    @FXML
    private TableColumn<TaskModel, String> tcDescription;

    @FXML
    private TableColumn<TaskModel, LocalDate> tcDeadline;

    @FXML
    private TableColumn<TaskModel, String> tcAssignee;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtAssignee;

    @FXML
    private DatePicker dpDeadline;

    public void initialize() {
        tvTasks.setItems(model.getTasks());
        tcComplete.setCellValueFactory(task -> task.getValue().getIsCompleted());
        tcDescription.setCellValueFactory(task -> task.getValue().getDescription());
        tcDeadline.setCellValueFactory(task -> task.getValue().getDeadline());
        tcAssignee.setCellValueFactory(task -> task.getValue().getAssignee());

        model.getSelectedTaskProperty().bind(tvTasks.getSelectionModel().selectedItemProperty());
        model.getNewTaskDescriptionProperty().bindBidirectional(txtDescription.textProperty());
        model.getNewTaskDeadlineProperty().bindBidirectional(dpDeadline.valueProperty());
        model.getNewTaskAssigneeProperty().bindBidirectional(txtAssignee.textProperty());
    }

    public void btnAddTaskClicked() {
        model.addTask();
    }

    public void btnPostpone1DayClicked() {
        model.getSelectedTaskProperty().get().postpone(1);
    }

    public void btnPostpone1WeekClicked() {
        model.getSelectedTaskProperty().get().postpone(7);
    }

    public void btnPostpone1MonthClicked() {
        model.getSelectedTaskProperty().get().postpone(31);
    }

    public void btnCompleteClicked() {
        model.getSelectedTaskProperty().get().complete();
    }

    public void btnRemoveClicked() {
        model.removeTask();
    }
}
