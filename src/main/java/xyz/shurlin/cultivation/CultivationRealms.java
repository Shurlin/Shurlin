package xyz.shurlin.cultivation;

public enum CultivationRealms {
    SOLDIER("soldier", 1, 3),
    EMISSARY("emissary", 2, 3),
    TEACHER("teacher", 3, 3),
    OVERLORD("overlord", 4, 3),
    GENERAL("general", 5, 6),
    MARQUIS("marquis", 6, 6),
    SENIOR("senior", 7, 6),
    MASTER("master", 8, 6),
    SOVEREIGN("sovereign", 9, 9),
    KING("king", 10, 9),
    EMPEROR("emperor", 11, 9),
    SAGE("sage", 12, 18);

    private String name;
    private short gradation;
    private short maxRank;

    CultivationRealms(String name, int gradation, int maxRank) {
        this.name = name;
        this.gradation = (short) gradation;
        this.maxRank = (short) maxRank;
    }

    public String getName() {
        return name;
    }

    public short getMaxRank() {
        return maxRank;
    }

    public CultivationRealms getNextGradation(){
        return getRealmByGradation((short) (gradation+1));
    }

    public short getGradation() {
        return gradation;
    }

    public static CultivationRealms getRealmByGradation(short gradation){
        switch (gradation){
            case 1:
                return SOLDIER;
            case 2:
                return EMISSARY;
            case 3:
                return TEACHER;
            case 4:
                return OVERLORD;
            case 5:
                return GENERAL;
            case 6:
                return MARQUIS;
            case 7:
                return SENIOR;
            case 8:
                return MASTER;
            case 9:
                return SOVEREIGN;
            case 10:
                return KING;
            case 11:
                return EMPEROR;
            case 12:
                return SAGE;
        }
        return null;
    }
}
