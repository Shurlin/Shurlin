package xyz.shurlin.item;

public class WeaponProperties {
    public static final WeaponProperties DARK_IRON = new WeaponProperties(8,6,-2.0f,-2.4f);

    private int attackWithSpirit;
    private int attackWithoutSpirit;
    private float speedWithSpirit;
    private float speedWithoutSpirit;

    public WeaponProperties(int attackWithSpirit, int attackWithoutSpirit, float speedWithSpirit, float speedWithoutSpirit) {
        this.attackWithSpirit = attackWithSpirit;
        this.attackWithoutSpirit = attackWithoutSpirit;
        this.speedWithSpirit = speedWithSpirit;
        this.speedWithoutSpirit = speedWithoutSpirit;
    }

    int getAttackWithSpirit() {
        return attackWithSpirit;
    }

    int getAttackWithoutSpirit() {
        return attackWithoutSpirit;
    }

    float getSpeedWithSpirit() {
        return speedWithSpirit;
    }

    float getSpeedWithoutSpirit() {
        return speedWithoutSpirit;
    }
}
