package com.stal111.valhelsia_structures.world;

import com.stal111.valhelsia_structures.init.ModStructures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * World Generation
 * ValhelsiaStructure - com.stal111.valhelsia_structure.world.WorldGen
 *
 * @author Valhelsia Team
 * @version 0.1
 * @since 2019-10-31
 */
public class WorldGen {

    /**
     * Setup World Generation
     */
    public static void setupWorldGen() {
        // Add Structures
        for (Biome biome : ForgeRegistries.BIOMES) {
            // Blacklisted biomes.
            if (biome == Biomes.RIVER) {
                continue;
            }

            // Use categories to allow compatibility with biome mods such as Biomes O' Plenty.
            if (biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.FOREST) {
                if (biome.getTempCategory() == Biome.TempCategory.MEDIUM && biome.getPrecipitation() == Biome.RainType.RAIN) {
                    addSurfaceStructure(biome, ModStructures.SMALL_CASTLE.get());
                    addSurfaceStructure(biome, ModStructures.TOWER_RUIN.get());
                    addSurfaceStructure(biome, ModStructures.PLAYER_HOUSE.get());
                    addSurfaceStructure(biome, ModStructures.FORGE.get());
                }
            }
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
                addUndergroundStructure(biome, ModStructures.SMALL_DUNGEON.get());
            }
        }
    }

    /**
     * Add a structure to the given biome.
     * @param biome The biome to add a structure to.
     * @param structure The structure to add.
     */
    private static void addSurfaceStructure(Biome biome, Structure<NoFeatureConfig> structure) {
        biome.addStructure(structure.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, structure.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }

    private static void addUndergroundStructure(Biome biome, Structure<NoFeatureConfig> structure) {
        biome.addStructure(structure.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, structure.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(8))));
    }
}
