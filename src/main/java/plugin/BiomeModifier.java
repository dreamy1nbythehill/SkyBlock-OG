package plugin;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kotlin.jvm.internal.Intrinsics;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;


public final class BiomeModifier extends BiomeProvider {

    public Biome getBiome( WorldInfo worldInfo, int x, int y, int z) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 6);
        generator.setScale(0.01);
        return Biome.OCEAN;
    }

    public List getBiomes(WorldInfo worldInfo) {
        Biome[] biome  = new Biome[]{Biome.OCEAN};
        return List.of(biome);
    }
}
