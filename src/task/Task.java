package task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Task implements Repeatable {
    private static int idGenerator = 0;
    private static int id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private TypeTask typeTask;

    public Task(String name, String description, TypeTask typeTask, LocalDateTime resultDate) {
        this.id = idGenerator++;
        setName(name);
        setDescription(description);
        this.typeTask = typeTask;
        this.startDate = resultDate;
    }


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean accessible(LocalDate inputDate) {
        return inputDate.isEqual(getStartDate().toLocalDate());
    }

    @Override
    public String toString() {
        return
                "Название задачи: " + name +
                ", Описание задачи: " + description +
                ", Время начала задачи: " + startDate.getHour() + ':' + startDate.getMinute() +
                ", тип задачи: " + typeTask.getName() + '\n';
    }
}
