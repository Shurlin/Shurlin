package xyz.shurlin.block.plant;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.sound.BlockSoundGroup;

public class BasicFlowerBlock extends FlowerBlock {
    public BasicFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration) {
        super(suspiciousStewEffect, effectDuration, FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
    }
}
