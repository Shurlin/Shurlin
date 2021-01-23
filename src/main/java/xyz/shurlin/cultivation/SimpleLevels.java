package xyz.shurlin.cultivation;

public enum SimpleLevels {
    LOW(1,"","low"),
    MIDDLE(2,"§a","middle"),
    HIGH(3,"§9","high");

    private final int level;
    private final String color;
    private final String name;

    SimpleLevels(int level, String color, String name) {
        this.level = level;
        this.color = color;
        this.name = name;
    }

    protected int getLevel() {
        return level;
    }

    protected String getColor() {
        return color;
    }

    protected String getName() {
        return name;
    }
}
