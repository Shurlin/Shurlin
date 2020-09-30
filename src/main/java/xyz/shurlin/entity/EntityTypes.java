package xyz.shurlin.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;
import xyz.shurlin.entity.projectile.BeanEntity;
import xyz.shurlin.entity.projectile.HolyPearArrowEntity;

public class EntityTypes {
    public static final EntityType<HolyPearArrowEntity> HOLY_PEAR_ARROW_ENTITY_TYPE =
            register("holy_pear_arrow_entity",
                    EntityType.Builder.create(
                            (EntityType.EntityFactory<HolyPearArrowEntity>)HolyPearArrowEntity::new, SpawnGroup.MISC)
                            .setDimensions(0.5f, 0.5f)
            );

    public static final EntityType<BeanEntity> BEAN_ENTITY_TYPE =
            register("bean",
                    EntityType.Builder.create(
                            (EntityType.EntityFactory<BeanEntity>)BeanEntity::new, SpawnGroup.MISC)
                            .setDimensions(0.5f, 0.5f)
            );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(Shurlin.MODID, name), type.build(name));
    }
}
