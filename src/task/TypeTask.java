package task;

public enum TypeTask {
    WORK("Рабочая"),
    PERSONAL("Личная");

    private final String name;

    TypeTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
