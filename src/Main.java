import task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(taskService, scanner);
                            break;
                        case 2:
                            removeTask(taskService, scanner);
                            break;
                        case 3:
                            getAllDateTask(taskService, scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static TaskService taskService = new TaskService();

    private static Task inputTask(TaskService taskSetting, Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        scanner.nextLine();

        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.nextLine();

        System.out.print("Введите дату задачи в формате дд.мм.гггг: ");
        String date = scanner.nextLine();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.print("Введите время задачи в формате чч:мм: ");
        String time = scanner.nextLine();
        LocalTime taskTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime resulDate = LocalDateTime.of(taskDate, taskTime);

        System.out.println("Введите тип задачи (личная - 1; рабочая - 2): ");
        int type = scanner.nextInt();
        if (type != 1 && type != 2) {
            throw new RuntimeException("Нет такого типа задачи!");
        }
        TypeTask typeTask1 = type == 1 ? TypeTask.PERSONAL : TypeTask.WORK;

        System.out.println("Введите формат задачи: (0-однократная; 1-ежедневная; 2-еженедельная; 3-ежемесячная; 4-ежегодная)");
        int typeTask = scanner.nextInt();

        switch (typeTask){
            case 0:
                taskService.addTask(new Task(taskName, taskDescription, typeTask1, resulDate));
                break;
            case 1:
                taskService.addTask(new DayTask(taskName, taskDescription, typeTask1, resulDate));
                break;
            case 2:
                taskService.addTask(new WeekTask(taskName, taskDescription, typeTask1, resulDate));
                break;
            case 3:
                taskService.addTask(new MonthTask(taskName, taskDescription, typeTask1, resulDate));
                break;
            case 4:
                taskService.addTask(new YearTask(taskName, taskDescription, typeTask1, resulDate));
                break;
            default:
                throw new RuntimeException("Нет такого формата задачи!");
        }
        return null;
    }


    private static void removeTask(TaskService taskService, Scanner scanner) {
        taskService.getAllTask();
        System.out.println("Введите id задачи, которую нужно удалить: ");
        int id = scanner.nextInt();
        taskService.remove(id);
    }

    private static void getAllDateTask(TaskService taskService, Scanner scanner) {
        System.out.print("Введите дату задачи в формате дд.мм.гггг: ");
        scanner.nextLine();
        String date = scanner.nextLine();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        var allDateTask = taskService.getAllDate(taskDate);
        System.out.println("Список задач на день: ");
        for (Task task : allDateTask) {
            System.out.println(task);
        }
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }
}