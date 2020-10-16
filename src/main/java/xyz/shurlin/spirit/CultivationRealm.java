package xyz.shurlin.spirit;

public class CultivationRealm {
    private CultivationRealms realm;
    private short rank;

    CultivationRealm() {
        this.realm = CultivationRealms.SOLDIER;
        this.rank = 1;
    }

    public CultivationRealm(CultivationRealms realm, short rank) {
        this.realm = realm;
        this.rank = rank;
    }

    public void upgrade(){
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
}
