package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthTask extends Task {

    public MonthTask(String name, String description, TypeTask typeTask, LocalDateTime resultDate) {
        super(name, description, typeTask, resultDate);
    }

    @Override
    public boolean accessible(LocalDate inputDate) {
        var startDay = getStartDate().toLocalDate();
        while (!startDay.isAfter(inputDate)) {
            if (startDay.equals(inputDate)) {
                return true;
            }
            startDay = startDay.plusMonths(1);
        }
        return false;
    }
}
