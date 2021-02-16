package xyz.shurlin.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import xyz.shurlin.world.gen.feature.ShurlinBiomeFeatures;
import xyz.shurlin.world.gen.feature.ShurlinConfiguredFeatures;
import xyz.shurlin.world.gen.feature.ShurlinConfiguredStructureFeatures;
import xyz.shurlin.world.gen.surfacebuilder.ShurlinConfiguredSurfaceBuilder;

public class ShurlinBiomeCreator {

    private static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static Biome createPearForest(){
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(builder);
        DefaultBiomeFeatures.addBatsAndMonsters(builder);
        GenerationSettings.Builder builder2 = new GenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder2);
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);
        builder2.structureFeature(ShurlinConfiguredStructureFeatures.ANCIENT_PEAR_TREE);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addDefaultLakes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addForestFlowers(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addForestGrass(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_WATER);

        ShurlinBiomeFeatures.addPearTrees(builder2);
        ShurlinBiomeFeatures.addSmallBud(builder2);
        ShurlinBiomeFeatures.addPlatycodonGrandiflorus(builder2);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.2f).temperature(0.6F).downfall(0.3F).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColor(0.6F)).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }

    public static Biome createParasolAncientForest(){
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(builder);
        DefaultBiomeFeatures.addBatsAndMonsters(builder);
        GenerationSettings.Builder builder2 = new GenerationSettings.Builder().surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(builder2);
        builder2.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        DefaultBiomeFeatures.addDefaultLakes(builder2);
        DefaultBiomeFeatures.addDungeons(builder2);
        DefaultBiomeFeatures.addForestFlowers(builder2);
        DefaultBiomeFeatures.addMineables(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addDefaultFlowers(builder2);
        DefaultBiomeFeatures.addForestGrass(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addSprings(builder2);

        ShurlinBiomeFeatures.addMysteriousStonePillar(builder2);
        ShurlinBiomeFeatures.addPlantObsidianHeap(builder2);
        ShurlinBiomeFeatures.addPhoenixTrees(builder2);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST).depth(0.1f).scale(0.2f).temperature(0.7F).downfall(0.1F).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColor(0.6F)).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }

    public static Biome createFireLand(){
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 2, 4, 4));
        GenerationSettings.Builder builder2 = new GenerationSettings.Builder().surfaceBuilder(ShurlinConfiguredSurfaceBuilder.FIRE_LAND).feature(GenerationStep.Feature.VEGETAL_DECORATION, ShurlinConfiguredFeatures.PATCH_FIRE);
        DefaultBiomeFeatures.addLandCarvers(builder2);
        ShurlinBiomeFeatures.addHotSprings(builder2);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.PLAINS).depth(0.2f).scale(0.2f).temperature(2.0F).downfall(0.0F).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColor(2.0F)).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }
}
