package xyz.shurlin.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.shurlin.Shurlin;
import xyz.shurlin.entity.passive.RoamingSpiritEntity;
import xyz.shurlin.entity.projectile.BeanEntity;
import xyz.shurlin.entity.projectile.HolyPearArrowEntity;

public class EntityTypes {
//    public static final EntityType<HolyPearArrowEntity> HOLY_PEAR_ARROW_ENTITY_TYPE =
//            register("holy_pear_arrow_entity",
//                    EntityType.Builder.create(
//                            (EntityType.EntityFactory<HolyPearArrowEntity>)HolyPearArrowEntity::new, SpawnGroup.MISC)
//                            .setDimensions(0.5f, 0.5f)
//            );
//
//    public static final EntityType<BeanEntity> BEAN_ENTITY_TYPE =
//            register("bean",
//                    EntityType.Builder.create(
//                            (EntityType.EntityFactory<BeanEntity>)BeanEntity::new, SpawnGroup.MISC)
//                            .setDimensions(0.5f, 0.5f)
//            );

    public static final EntityType<RoamingSpiritEntity> ROAMING_SPIRIT_ENTITY_TYPE =
            register("roaming_spirit_entity_type",
                    EntityType.Builder.create(RoamingSpiritEntity::new, SpawnGroup.CREATURE).setDimensions(0.6f,0.6f).maxTrackingRange(8));

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(Shurlin.MODID, name), type.build(name));
    }

    public static void registerAll(){
        FabricDefaultAttributeRegistry.register(ROAMING_SPIRIT_ENTITY_TYPE, RoamingSpiritEntity.createMobAttributes());

    }
}
