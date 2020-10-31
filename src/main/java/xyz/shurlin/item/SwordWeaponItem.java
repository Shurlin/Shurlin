package xyz.shurlin.item;

import xyz.shurlin.cultivation.WeaponLevels;

public class SwordWeaponItem extends BasicWeaponItem {
    public SwordWeaponItem(Settings settings, WeaponLevels level) {
        super(settings, level);
    }

    public SwordWeaponItem(WeaponLevels level) {
        super(new Settings().maxCount(1), level);
    }
}
