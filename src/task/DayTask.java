package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DayTask extends Task {

    public DayTask(String name, String description, TypeTask typeTask, LocalDateTime resultDate) {
        super(name, description, typeTask, resultDate);
    }

    @Override
    public boolean accessible(LocalDate inputDate) {
        var startDay = getStartDate().toLocalDate();
        while (!startDay.isAfter(inputDate)) {
            if (startDay.equals(inputDate)) {
                return true;
            }
            startDay = startDay.plusDays(1);
        }
        return false;
    }
}
