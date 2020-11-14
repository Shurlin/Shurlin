package xyz.shurlin.cultivation;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;

public class SpiritMeridians implements Tickable {
    private SpiritPropertyType type;
    private short level;
    private double maxSpirit;
    private double curSpirit;
    private double curEx;
    private static double[] ratios = new double[]{0, 1d, 3d, 10d, 30d, 100d, 300d, 1e3, 3e3, 1e4};

    SpiritMeridians(SpiritPropertyType type) {
        this.type = type;
        this.level = 1;
        this.maxSpirit = ratios[level];
        this.curSpirit = maxSpirit;
    }

    private SpiritMeridians(SpiritPropertyType type, short level, double curSpirit) {
        this.type = type;
        this.level = level;
        this.curSpirit = curSpirit;
    }

    public void upgrade(){
        this.curEx = 0;
        this.level++;
        this.maxSpirit = ratios[this.level];
        this.curSpirit = this.maxSpirit;
    }

    private double getMaxSpirits(int ratio){
        return ratio * 1e3;
    }

    public void heal(){
        if(this.curSpirit < this.maxSpirit)
            this.curSpirit += ratios[this.level];
        this.check();
    }

    public void increase(double d){
        this.curSpirit += d;
        this.check();
    }

    public void decrease(double d){
        this.curSpirit -= d;
        this.check();
    }

    private void check(){
        if(this.level < 9 && this.curEx >= ratios[this.level+1]*1e2)
            this.upgrade();
        if(this.curSpirit>this.maxSpirit)
            this.curSpirit = this.maxSpirit;
        else if(this.curSpirit < 0)
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

    CompoundTag toTag(){
        CompoundTag tag = new CompoundTag();
        tag.putShort("level", this.level);
        tag.putDouble("cur_spirit",this.curSpirit);
        return tag;
    }

    static SpiritMeridians fromTag(SpiritPropertyType type, CompoundTag tag){
        return new SpiritMeridians(type, tag.getShort("level"), tag.getDouble("cur_spirit"));
    }

    @Override
    public void tick() {
        this.heal();
    }
}
