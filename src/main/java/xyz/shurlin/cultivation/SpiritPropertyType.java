package xyz.shurlin.cultivation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

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

    private final String name;
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

    public String getTranslation(){
        return "type.shurlin." + this.name;
    }

    @Environment(EnvType.CLIENT)
    public int getId() {
        switch (this) {
            case METAL:
                return 1;
            case WOOD:
                return 2;
            case WATER:
                return 3;
            case FIRE:
                return 4;
            case EARTH:
                return 5;
            case WIND:
                return 6;
            case LIGHT:
                return 7;
            case DARKNESS:
                return 8;
            case POISON:
                return 9;
            case LIGHTNING:
                return 10;
            case ICE:
                return 11;
            case TIME_SPACE:
                return 12;
            default:
                return 0;
        }
    }

    /*
    for(SpiritPropertyType type: SpiritPropertyType.GROUPS){
            realm.putMeridians(type, SpiritMeridians.fromTag(type, tag1));
        }
     */
}
