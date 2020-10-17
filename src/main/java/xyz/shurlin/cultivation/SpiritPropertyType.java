package xyz.shurlin.cultivation;

public enum SpiritPropertyType {
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
    public static final SpiritPropertyType[] GROUPS = new SpiritPropertyType[]{
            METAL,
            WOOD,
            WATER,
            FIRE,
            EARTH,
            WIND,
            LIGHT,
            DARKNESS,
            POISON,
            LIGHTNING,
            ICE,
            TIME_SPACE
    };

    SpiritPropertyType(String name) {
        this.name = name;
    }
}
