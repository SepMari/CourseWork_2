package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeekTask extends Task {

    public WeekTask(String name, String description, TypeTask typeTask, LocalDateTime resultDate) {
        super(name, description, typeTask, resultDate);
    }

    @Override
    public boolean accessible(LocalDate inputDate) {
        var startDay = getStartDate().toLocalDate();
        while (!startDay.isAfter(inputDate)) {
            if (startDay.equals(inputDate)) {
                return true;
            }
            startDay = startDay.plusWeeks(1);
        }
        return false;
    }
}
