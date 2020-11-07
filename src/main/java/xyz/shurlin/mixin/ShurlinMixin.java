package xyz.shurlin.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.Entity;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.shurlin.world.gen.feature.ShurlinBiomeFeatures;

@Mixin(ShurlinBiomeFeatures.class)
public class ShurlinMixin {
//    @Inject(at = @At("HEAD"), method = "addPearTrees(Lnet/minecraft/world/biome/Biome;)V")
//    private static void addPearTrees(Biome biome, CallbackInfo info) {
//        System.out.println(biome.getName());
//    }
}
