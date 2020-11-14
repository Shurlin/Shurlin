package xyz.shurlin.reflect;

import net.minecraft.entity.EntityPose;

import java.lang.reflect.Constructor;

public class Reflector {
    public static final EnumBuster<EntityPose> ENTITY_POSE_ENUM_BUSTER = new EnumBuster<>(EntityPose.class);
    public static final EntityPose MEDITATING = ENTITY_POSE_ENUM_BUSTER.make("MEDITATING");

}
