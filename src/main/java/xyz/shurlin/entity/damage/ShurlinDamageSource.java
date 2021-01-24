package xyz.shurlin.entity.damage;

import net.minecraft.entity.damage.DamageSource;

public class ShurlinDamageSource extends DamageSource {
    public static ShurlinDamageSource SMALL_BUD = new ShurlinDamageSource("shurlin.small_bud");

    public ShurlinDamageSource(String name) {
        super(name);
    }
}
