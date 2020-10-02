package xyz.shurlin.world.biome;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import xyz.shurlin.block.Blocks;
import xyz.shurlin.world.gen.feature.ShurlinBiomeFeatures;
import xyz.shurlin.world.gen.feature.StructureFeatures;

import java.util.Locale;

import static net.minecraft.world.gen.feature.StructureFeature.STRUCTURES;

public class BiomeGenerator {
    public BiomeGenerator() {
        Registry.BIOME.forEach(this::handleBiome);
        STRUCTURES.put("ancient_oak_tree", StructureFeatures.ANCIENT_OAK_TREE);
        STRUCTURES.put("ancient_pear_tree", StructureFeatures.ANCIENT_PEAR_TREE);
        Biomes.DARK_FOREST.addStructureFeature(ShurlinBiomeFeatures.ANCIENT_DARK_OAK_TREE);//TODO
    }

    private void handleBiome(Biome biome){
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            addOres(biome, Blocks.PLANT_IRON_ORE_BLOCK, 6, 6, 32);
            addOres(biome, Blocks.PLANT_GOLD_ORE_BLOCK, 4, 4, 24);
            addOres(biome, Blocks.PLANT_JADE_ORE_BLOCK, 4, 2, 16);

        }
        if(biome.getCategory() == Biome.Category.NETHER){
            addOres(biome, OreFeatureConfig.Target.NETHERRACK, Blocks.TENUOUS_METAL_SPIRIT_ORE_BLOCK, 2, 2, 16);
            addOres(biome, OreFeatureConfig.Target.NETHERRACK, Blocks.TENUOUS_FIRE_SPIRIT_ORE_BLOCK, 2, 2, 16);
        }else if(biome.getCategory() == Biome.Category.JUNGLE){
            addOres(biome, Blocks.TENUOUS_WOOD_SPIRIT_ORE_BLOCK, 4, 4, 16);
        }else if(biome.getCategory() == Biome.Category.OCEAN){
            addOres(biome, Blocks.TENUOUS_WATER_SPIRIT_ORE_BLOCK, 2, 3, 16);
        }else if(biome.getCategory() == Biome.Category.EXTREME_HILLS){
            addOres(biome, Blocks.TENUOUS_EARTH_SPIRIT_ORE_BLOCK, 4, 2, 16);
        }else if(biome.getCategory() == Biome.Category.PLAINS){
            addOres(biome, Blocks.TENUOUS_WIND_SPIRIT_ORE_BLOCK, 2, 2, 16);
        }else if(biome.getCategory() == Biome.Category.DESERT){
            addOres(biome, Blocks.TENUOUS_LIGHT_SPIRIT_ORE_BLOCK, 4, 2, 16);
        }
//        else if(biome.getCategory() == Biome.Category.THEEND){
//            addOres(biome, Blocks.TENUOUS_WOOD_SPIRIT_ORE_BLOCK, 4, 4, 16);
//            addOres(biome, Blocks.TENUOUS_WOOD_SPIRIT_ORE_BLOCK, 4, 4, 16);
//        }
        else if(biome.getCategory() == Biome.Category.SWAMP){
            addOres(biome, Blocks.TENUOUS_POISON_SPIRIT_ORE_BLOCK, 4, 2, 16);
        }
    }

    private void addOres(Biome biome, OreFeatureConfig.Target target,Block block, int size, int countPerChunk, int maximum){
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                target,
                                block.getDefaultState(),
                                size //Ore vein size
                        )).createDecoratedFeature(
                        Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                                countPerChunk, //Number of veins per chunk
                                0, //Bottom Offset
                                0, //Min y level
                                maximum //Max y level
                        ))));
    }

    private void addOres(Biome biome, Block block, int size, int countPerChunk, int maximum){
        addOres(biome,OreFeatureConfig.Target.NATURAL_STONE, block, size, countPerChunk, maximum);
    }

//    private void addOres(Biome biome,Block block, int size, int countPerChunk, int maximum){
//        biome.addFeature( //为对应的生物群系添加一个特征
//                GenerationStep.Feature.UNDERGROUND_ORES,//声明这个特征是一个矿物特征
//                Feature.ORE.configure(//这里指配置过后的矿物特征
//                        new OreFeatureConfig(//矿物特征配置
//                                OreFeatureConfig.Target.NATURAL_STONE,//指在普通的石头中生成
//                                block.getDefaultState(),//对应生成方块的状态
//                                size //一堆矿所包含的方块数量
//                        )).createDecoratedFeature(//对这个特征进行装饰
//                        Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(//一个数量范围装饰器
//                                countPerChunk, //每个区块生成多少堆这种矿
//                                0, //这个忘了
//                                0, //y坐标最低
//                                maximum //y坐标最高
//                        ))));
//    }



}
