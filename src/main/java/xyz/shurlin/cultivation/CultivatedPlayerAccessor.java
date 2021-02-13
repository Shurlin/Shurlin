package xyz.shurlin.cultivation;

public interface CultivatedPlayerAccessor {
    void setter(CultivationRealm realm);

    CultivationRealm getter();
}
