package xyz.shurlin.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.shurlin.cultivation.*;


@Mixin(PlayerEntity.class)
public class CultivatedPlayerMixin implements CultivatedPlayerAccessor {

    @Unique
    private CultivationRealm realm;

    @Inject(at = @At("TAIL"), method = "readCustomDataFromTag(Lnet/minecraft/nbt/CompoundTag;)V")
    private void readCultivationFromTag(CompoundTag tag, CallbackInfo ci) {
        setter(fromTag(tag));
    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToTag(Lnet/minecraft/nbt/CompoundTag;)V")
    private void writeCultivationToTag(CompoundTag tag, CallbackInfo ci) {
        tag.put("cul", toTag());
    }

//    @Inject(at = @At("TAIL"), method = "tick()V")
//    private void tick(CallbackInfo callbackInfo) {
//        this.realm.healSpiritMeridians(1);
//    }

    @Override
    public void setter(CultivationRealm realm) {
        this.realm = realm;
    }

    @Override
    public CultivationRealm getter() {
        return this.realm;
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        CultivationRealm realm = getter();
        if (realm != null) {
            tag.putBoolean("isCultivated", true);
            tag.putShort("gradation", realm.getRealm().getGradation());
            tag.putShort("rank", realm.getRank());
            int sm_cnt = 0;
            CompoundTag sm_tag = new CompoundTag();
            for (SpiritPropertyType type : SpiritPropertyType.GROUPS) {
                sm_tag.put(String.valueOf(sm_cnt++), realm.getMeridians(type).toTag());
            }
            tag.put("sm", sm_tag);
        } else
            tag.putBoolean("isCultivated", false);
        return tag;
    }

    public CultivationRealm fromTag(CompoundTag tags) {
        CompoundTag tag = tags.getCompound("cul");
        if (!tag.getBoolean("isCultivated"))
            return null;
        short gradation = tag.getShort("gradation");
        short rank = tag.getShort("rank");
        CultivationRealm realm = new CultivationRealm(CultivationRealms.getRealmByGradation(gradation), rank);
        CompoundTag sm_tag = tag.getCompound("sm");
        int sm_cnt = 0;
        for (SpiritPropertyType type : SpiritPropertyType.GROUPS) {
            CompoundTag tag1 = sm_tag.getCompound(String.valueOf(sm_cnt++));
            realm.putMeridians(type, SpiritMeridians.fromTag(type, tag1));
        }
        return realm;
    }
}
