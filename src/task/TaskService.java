package task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class TaskService {
    private Map<Integer, Task> map = new HashMap<>();

    public void addTask(Task task) {
        map.put(task.getId(), task);
    }

    public void remove(int id) {
        map.remove(id);
    }

    public void getAllTask() {
        for (Map.Entry<Integer, Task> allTask : map.entrySet()) {
            System.out.println(allTask);
        }
    }

    public Collection<Task> getAllDate(LocalDate inputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : map.entrySet()) {
            var task = integerTaskEntry.getValue();
            if (task.accessible(inputDate)) {
                resultList.add(task);
            }
        }
        return resultList;
    }
}
