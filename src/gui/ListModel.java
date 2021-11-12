package gui;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ListModel {
    private ObservableList<TaskModel> tasks = FXCollections.observableArrayList();
    private ObjectProperty<TaskModel> selectedTask = new SimpleObjectProperty<>();
    private StringProperty newTaskDescription = new SimpleStringProperty();
    private ObjectProperty<LocalDate> newTaskDeadline = new SimpleObjectProperty<>();
    private StringProperty newTaskAssignee = new SimpleStringProperty();

    public ObservableList<TaskModel> getTasks() {
        return tasks;
    }

    public ObjectProperty<TaskModel> getSelectedTaskProperty() {
        return selectedTask;
    }

    public StringProperty getNewTaskDescriptionProperty() {
        return newTaskDescription;
    }

    public ObjectProperty<LocalDate> getNewTaskDeadlineProperty() {
        return newTaskDeadline;
    }

    public StringProperty getNewTaskAssigneeProperty() {
        return newTaskAssignee;
    }

    public void addTask() {
        tasks.add(new TaskModel(getNewTaskDescriptionProperty().get(), getNewTaskDeadlineProperty().get(), getNewTaskAssigneeProperty().get()));
    }

    public void removeTask() {
        tasks.remove(selectedTask.get());
    }
}
