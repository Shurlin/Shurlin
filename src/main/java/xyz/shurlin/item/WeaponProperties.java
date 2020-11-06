package xyz.shurlin.item;

public class WeaponProperties {

    private int attackWithSpirit;
    private int attackWithoutSpirit;
    private int speedWithSpirit;
    private int speedWithoutSpirit;

    public WeaponProperties(int attackWithSpirit, int attackWithoutSpirit, int speedWithSpirit, int speedWithoutSpirit) {
        this.attackWithSpirit = attackWithSpirit;
        this.attackWithoutSpirit = attackWithoutSpirit;
        this.speedWithSpirit = speedWithSpirit;
        this.speedWithoutSpirit = speedWithoutSpirit;
    }

    public int getAttackWithSpirit() {
        return attackWithSpirit;
    }

    public int getAttackWithoutSpirit() {
        return attackWithoutSpirit;
    }

    public int getSpeedWithSpirit() {
        return speedWithSpirit;
    }

    public int getSpeedWithoutSpirit() {
        return speedWithoutSpirit;
    }
}
