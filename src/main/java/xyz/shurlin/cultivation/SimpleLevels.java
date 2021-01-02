package xyz.shurlin.cultivation;

public enum SimpleLevels {
    LOW(1,"","low"),
    MIDDLE(2,"§a","middle"),
    HIGH(3,"§9","high");

    private int level;
    private String color;
    private String name;

    SimpleLevels(int level, String color, String name) {
        this.level = level;
        this.color = color;
        this.name = name;
    }
}
