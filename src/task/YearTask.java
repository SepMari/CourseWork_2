package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task{
    public YearTask(String name, String description, TypeTask typeTask, LocalDateTime resultDate) {
        super(name, description, typeTask, resultDate);
    }

    @Override
    public boolean Accessible(LocalDate inputDate) {
        var startDay = getStartDate().toLocalDate();
        while (!startDay.isAfter(inputDate)) {
            if (startDay.equals(inputDate)) {
                return true;
            }
            startDay = startDay.plusYears(1);
        }
        return false;
    }
}
