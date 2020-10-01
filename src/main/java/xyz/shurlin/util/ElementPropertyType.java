package xyz.shurlin.util;

public enum ElementPropertyType {
    METAL("metal"),
    WOOD("wood"),
    WATER("water"),
    FIRE("fire"),
    EARTH("earth"),
    WIND("wind"),
    LIGHT("light"),
    DARKNESS("darkness"),
    POISON("poison"),
    LIGHTNING("lightning"),
    ICE("ice"),
    TIME_SPACE("time_space");

    public final String name;

    ElementPropertyType(String name) {
        this.name = name;
    }
}
