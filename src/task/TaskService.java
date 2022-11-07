package task;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Map<Integer, Task> map = new HashMap<>();
    private Collection<Task> removedTask;

    public void addTask(Task task) {
        map.put(task.getId(), task);
    }

    public void remove(int id) {
        map.remove(id);
    }

    public Collection<Task> getAllDate(LocalDate inputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : map.entrySet()) {
            var task = integerTaskEntry.getValue();
            if (task.Accessible(inputDate)) {
                resultList.add(task);
            }
        }
        return resultList;
    }
}
