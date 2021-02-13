package xyz.shurlin.cultivation;

import net.minecraft.nbt.CompoundTag;

public class SpiritMeridians {
    private final SpiritPropertyType type;
    private short level;
    private double maxSpirit;
    private double curSpirit;
    private double curEx;
    private double maxEx;
    private static final double[] ratios = new double[]{0, 1d, 3d, 10d, 30d, 100d, 300d, 1e3, 3e3, 1e4};

    public SpiritMeridians(SpiritPropertyType type) {
        this.type = type;
        this.level = 1;
        this.maxSpirit = getMaxSpirits(level);
        this.curSpirit = maxSpirit;
        this.maxEx = getMaxExs(level);
    }

    public SpiritMeridians(SpiritPropertyType type, short level, double curSpirit, double curEx) {
        this.type = type;
        this.level = level;
        this.curSpirit = curSpirit;
        this.curEx = curEx;
        this.maxSpirit = getMaxSpirits(level);
        this.maxEx = getMaxExs(level);

    }

    public void upgrade() {
        this.curEx = 0;
        this.level++;
        this.maxSpirit = getMaxSpirits(level);
        this.maxEx = getMaxExs(level);
        this.curSpirit = this.maxSpirit;
    }

    static double getMaxSpirits(int level) {
        return ratios[level] * 1e3;
    }

    static double getMaxExs(int level) {
        return ratios[level] * 100d;
    }

    public void heal(int times) {
        if (this.curSpirit < this.maxSpirit)
            this.curSpirit += ratios[this.level] * times;
        this.check();
    }

    public void increase(double d) {
        this.curSpirit += d;
        this.check();
    }

    public void decrease(double d) {
        this.curSpirit -= d;
        this.check();
    }

    private void check() {
        if (this.level < 9 && this.curEx >= this.maxEx)
            this.upgrade();
        if (this.curSpirit > this.maxSpirit)
            this.curSpirit = this.maxSpirit;
        else if (this.curSpirit < 0)
            this.curSpirit = 0;
    }

    public SpiritPropertyType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public double getMaxSpirit() {
        return maxSpirit;
    }

    public double getCurSpirit() {
        return curSpirit;
    }

    public double getCurEx() {
        return curEx;
    }

    public double getMaxEx() {
        return maxEx;
    }

    public CompoundTag toTag() {
        CompoundTag tag = new CompoundTag();
        tag.putShort("level", this.level);
        tag.putDouble("cur_spirit", this.curSpirit);
        tag.putDouble("cur_ex", this.curEx);
        return tag;
    }

    public static SpiritMeridians fromTag(SpiritPropertyType type, CompoundTag tag) {
        return new SpiritMeridians(type,
                tag.getShort("level"),
                tag.getDouble("cur_spirit"),
                tag.getDouble("cur_ex"));
    }
}
