package xyz.shurlin.cultivation;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;

public class CultivationRealm {
    private CultivationRealms realm;
    private short rank;
    private Object2ObjectArrayMap<SpiritPropertyType, SpiritMeridians> meridians = new Object2ObjectArrayMap<>();

    CultivationRealm() {
        this.realm = CultivationRealms.SOLDIER;
        this.rank = 1;
        for(SpiritPropertyType type: SpiritPropertyType.GROUPS){
            this.meridians.put(type, new SpiritMeridians(type));
        }

    }

    public CultivationRealm(CultivationRealms realm, short rank) {
        this.realm = realm;
        this.rank = rank;
    }

    public void upgrade(){
        if(best())
            return;
        if(rank == realm.getMaxRank()){
            this.realm = realm.getNextGradation();
            this.rank = 1;
        }
        else rank++;
    }

    public CultivationRealms getRealm() {
        return realm;
    }

    public short getRank() {
        return rank;
    }

    public String getDescribe(){
        return realm.getName() + ' ' + rank;
    }

    public boolean best(){
        return this.realm.getGradation() == 12 && this.rank == 18;
    }

    public SpiritMeridians getMeridians(SpiritPropertyType type) {
        return meridians.get(type);
    }

    public void putMeridians(SpiritPropertyType type, SpiritMeridians meridians){
        this.meridians.put(type, meridians);
    }
}
