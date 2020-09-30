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
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC,
                            (EntityType.EntityFactory<HolyPearArrowEntity>)HolyPearArrowEntity::new)
                            .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build()
            );

    public static final EntityType<BeanEntity> BEAN_ENTITY_TYPE =
            register("bean",
                    FabricEntityTypeBuilder.create(SpawnGroup.MISC,
                            (EntityType.EntityFactory<BeanEntity>)BeanEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f,0.2f)).build()
            );

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(Shurlin.MODID, name), type);
    }
}
