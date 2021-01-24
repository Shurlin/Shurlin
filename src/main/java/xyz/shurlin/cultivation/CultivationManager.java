package xyz.shurlin.cultivation;

import annotations.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;
import java.util.Vector;

public class CultivationManager {
    public static CultivationManager INSTANCE = new CultivationManager();
    private final Vector<UUID> id_map = new Vector<>();
    private final Vector<CultivationRealm> cul_map = new Vector<>();
            
    private CultivationManager() {
    }

    public CompoundTag toTag(UUID uuid){
        CompoundTag tag = new CompoundTag();
        if(!id_map.contains(uuid)){
            tag.putBoolean("isCultivated", false);
            return tag;
        }
        tag.putBoolean("isCultivated", true);
        CultivationRealm realm = cul_map.elementAt(id_map.indexOf(uuid));
        tag.putShort("gradation", realm.getRealm().getGradation());
        tag.putShort("rank", realm.getRank());
        int sm_cnt = 0;
        CompoundTag sm_tag = new CompoundTag();
        for(SpiritPropertyType type: SpiritPropertyType.GROUPS){
            sm_tag.put(String.valueOf(sm_cnt++), realm.getMeridians(type).toTag());
        }
        tag.put("sm", sm_tag);
        return tag;
    }
    
    public void fromTag(CompoundTag tags, UUID uuid){
        CompoundTag tag = tags.getCompound("cul");
        if(!tag.getBoolean("isCultivated"))
            return;
//        UUID uuid = tags.getUuid("UUID");
        short gradation = tag.getShort("gradation");
        short rank = tag.getShort("rank");
        id_map.add(uuid);
        CultivationRealm realm = new CultivationRealm(CultivationRealms.getRealmByGradation(gradation), rank);
        CompoundTag sm_tag = tag.getCompound("sm");
        int sm_cnt = 0;
        for(SpiritPropertyType type: SpiritPropertyType.GROUPS){
            CompoundTag tag1 = sm_tag.getCompound(String.valueOf(sm_cnt++));
            realm.putMeridians(type, SpiritMeridians.fromTag(type, tag1));
        }
        cul_map.add(realm);
    }

    @Nullable
    public CultivationRealm getCultivationRealmByEntity(Entity entity){
        UUID uuid = entity.getUuid();
        if(!isCultivated(entity))
            return null;
        return cul_map.get(id_map.indexOf(uuid));
    }

    public boolean isCultivated(Entity entity){
        return id_map.contains(entity.getUuid());
    }

    public CultivationRealm appendCultivationEntity(Entity entity){
        UUID uuid = entity.getUuid();
        id_map.add(uuid);
        CultivationRealm realm = new CultivationRealm();
        cul_map.add(realm);
        return realm;
    }
}
