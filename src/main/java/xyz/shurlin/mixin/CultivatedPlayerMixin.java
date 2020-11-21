package xyz.shurlin.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.shurlin.cultivation.CultivationManager;

@Mixin(PlayerEntity.class)
public class CultivatedPlayerMixin {
    @Inject(at = @At("TAIL"), method = "readCustomDataFromTag(Lnet/minecraft/nbt/CompoundTag;)V")
    private void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        CultivationManager.INSTANCE.fromTag(tag);
    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToTag(Lnet/minecraft/nbt/CompoundTag;)V")
    private void writeCustomDataToTag(CompoundTag tag, CallbackInfo ci) {
        tag.put("cul", CultivationManager.INSTANCE.toTag(tag.getUuid("UUID")));
    }
}
