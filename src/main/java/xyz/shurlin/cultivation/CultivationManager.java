package xyz.shurlin.cultivation;

import annotations.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;
import java.util.Vector;

public class CultivationManager {
    public static CultivationManager INSTANCE = new CultivationManager();
    private Vector<UUID> id_map = new Vector<>();
    private Vector<CultivationRealm> cul_map = new Vector<>();
            
    private CultivationManager() {
    }

    public CompoundTag toTag(){
        CompoundTag tags = new CompoundTag();
        tags.putInt("cnt", id_map.size());
        for(int i = 0;i < id_map.size();i++){
            UUID uuid = id_map.elementAt(i);
            CultivationRealm realm = cul_map.elementAt(i);
            CompoundTag tag = new CompoundTag();
            tag.putUuid("uuid", uuid);
            tag.putShort("gradation", realm.getRealm().getGradation());
            tag.putShort("rank", realm.getRank());
            int sm_cnt = 0;
            CompoundTag sm_tag = new CompoundTag();
            for(SpiritPropertyType type: SpiritPropertyType.GROUPS){
                sm_tag.put(String.valueOf(sm_cnt++), realm.getMeridians(type).toTag());
            }
            tag.put("sm", sm_tag);
            tags.put(String.valueOf(i), tag);
        }
        return tags;
    }
    
    public void fromTag(CompoundTag tags){
        int cnt = tags.getInt("cnt");
        for(int i = 0;i<cnt;i++){
            CompoundTag tag = tags.getCompound(String.valueOf(i));
            UUID uuid = tag.getUuid("uuid");
            short gradation = tag.getShort("gradation");
            short rank = tag.getShort("rank");
            id_map.add(uuid);
            CultivationRealm realm = new CultivationRealm(CultivationRealms.getRealmByGradation(gradation), rank);
            CompoundTag sm_tag = tags.getCompound("sm");
            int sm_cnt = 0;
            for(SpiritPropertyType type: SpiritPropertyType.GROUPS){
                CompoundTag tag1 = sm_tag.getCompound(String.valueOf(sm_cnt++));
                realm.putMeridians(type, SpiritMeridians.fromTag(type, tag1));
            }
            cul_map.add(realm);
        }
    }

    @Nullable
    public CultivationRealm getCultivationRealmByEntity(Entity entity){
        UUID uuid = entity.getUuid();
        if(!id_map.contains(uuid))
            return null;
        return cul_map.get(id_map.indexOf(uuid));
    }

    public CultivationRealm appendCultivationEntity(Entity entity){
        UUID uuid = entity.getUuid();
        id_map.add(uuid);
        CultivationRealm realm = new CultivationRealm();
        cul_map.add(realm);
        return realm;
    }
}
