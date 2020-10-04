package xyz.shurlin.item;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import xyz.shurlin.util.Collectable;

public class PlantExtractantItem extends ExtractantItem implements Collectable {
    public PlantExtractantItem(int extractant) {
        super(extractant);
    }

    @Override
    public int getConsistence(World world, Vec3i pos) {
        switch (world.getBiome((BlockPos)pos).getCategory()){
            case FOREST:
                return 60;
            case TAIGA:
                return 40;
            case PLAINS:
                return 20;
            case SAVANNA:
                return 30;
            case JUNGLE:
                return 80;
        }
        return 0;
    }

    @Override
    public int getTime() {
        return 60000;
    }
}
