package xyz.shurlin.cultivation;

public enum WeaponLevels {
    INFERIOR_WEAPON(1),
    STANDARD_WEAPON(2),
    QUALITY_WEAPON(3),
    INFERIOR_TAO_WEAPON(4),
    STANDARD_TAO_WEAPON(5),
    QUALITY_TAO_WEAPON(6),
    INFERIOR_HOLY_WEAPON(7),
    HOLY_WEAPON(8),
    SUPER_HOLY_WEAPON(9),
    HOLY_SPIRIT_WEAPON(10);

    private final int lvl;

    WeaponLevels(int lvl) {
        this.lvl = lvl;
    }

    public boolean unbreakable(){
        return this.lvl >= 8;
    }

    public int getLevel() {
        return lvl;
    }
}
