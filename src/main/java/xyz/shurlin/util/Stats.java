package xyz.shurlin.util;

import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Stats {
    public static final Identifier USE_WORKER;
    public static final Identifier OPEN_HOLY_PEAR_BAG;

    private static Identifier register(String string, StatFormatter statFormatter) {
        Identifier identifier = new Identifier(string);
        Registry.register(Registry.CUSTOM_STAT, string, identifier);
        net.minecraft.stat.Stats.CUSTOM.getOrCreateStat(identifier, statFormatter);
        return identifier;
    }

    static {
        USE_WORKER = register("use_worker", StatFormatter.DEFAULT);
        OPEN_HOLY_PEAR_BAG = register("open_holy_pear_bag", StatFormatter.DEFAULT);
    }
}
