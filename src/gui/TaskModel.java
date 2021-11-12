package gui;

import javafx.beans.property.*;

import java.time.LocalDate;

public class TaskModel {

    private ObjectProperty<LocalDate> deadline = new SimpleObjectProperty<>();
    private StringProperty assignee = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private BooleanProperty isCompleted = new SimpleBooleanProperty();

    public TaskModel(String description, LocalDate deadline, String assignee)
    {
        this.description.set(description);
        this.deadline.set(deadline);
        this.assignee.set(assignee);
    }

    public ObjectProperty<LocalDate> getDeadline() {
        return deadline;
    }

    public StringProperty getAssignee() {
        return assignee;
    }

    public StringProperty getDescription() {
        return description;
    }

    public BooleanProperty getIsCompleted() {
        return isCompleted;
    }

    public void postpone(int numberOfDays) {
        deadline.set(deadline.get().plusDays(numberOfDays));
    }

    public void complete() {
        isCompleted.set(true);
    }
}