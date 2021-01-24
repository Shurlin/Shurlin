package xyz.shurlin.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;

public class StatusEffects {
    public static final StatusEffect LOVED;

    private static StatusEffect register(String registryName, StatusEffect effect){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Shurlin.MODID, registryName), effect);
    }

    static {
        LOVED = register("loved", new BasicStatusEffect(StatusEffectType.BENEFICIAL, 13458603));
    }
}
