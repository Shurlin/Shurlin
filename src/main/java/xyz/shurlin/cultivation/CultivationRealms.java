package xyz.shurlin.cultivation;

import annotations.Nullable;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;

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

    private final String name;
    private final short gradation;
    private final short maxRank;

    CultivationRealms(String name, int gradation, int maxRank) {
        this.name = name;
        this.gradation = (short) gradation;
        this.maxRank = (short) maxRank;

        Map.INSTANCE.put(this.gradation, this);
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

    /**
     * Simplified this method by putting a map.
     * @author Garay Shurlin
     * @author teddyxlandlee
     * @since 0.1.2-beta
     * @see xyz.shurlin.cultivation.CultivationRealms.Map
     */
    @Nullable
    public static CultivationRealms getRealmByGradation(short gradation) {
        return Map.INSTANCE.getOrDefault(gradation, null);
    }

    /**
     * Simplified {@link #getRealmByGradation} method by putting a map.
     * @author Garay Shurlin
     * @author teddyxlandlee
     * @since 0.1.2-beta
     * @see it.unimi.dsi.fastutil.shorts.Short2ObjectMap
     * @see it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap
     * @see #getRealmByGradation(short)
     */
    static final class Map extends Short2ObjectOpenHashMap<CultivationRealms> {
        static final Map INSTANCE = new Map();
        private Map() {}
    }
}
