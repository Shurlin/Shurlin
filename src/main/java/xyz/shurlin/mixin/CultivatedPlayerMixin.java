package xyz.shurlin.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static xyz.shurlin.cultivation.CultivationManager.fromTag;
import static xyz.shurlin.cultivation.CultivationManager.toTag;

@Mixin(PlayerEntity.class)
public abstract class CultivatedPlayerMixin {

    @Shadow @Final private GameProfile gameProfile;

    @Inject(at = @At("TAIL"), method = "readCustomDataFromTag(Lnet/minecraft/nbt/CompoundTag;)V")
    private void readCultivationFromTag(CompoundTag tag, CallbackInfo ci) {
        fromTag(tag, this.gameProfile.getId());

    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToTag(Lnet/minecraft/nbt/CompoundTag;)V")
    private void writeCultivationToTag(CompoundTag tag, CallbackInfo ci) {
        tag.put("cul", toTag(tag.getUuid("UUID")));
    }
}
