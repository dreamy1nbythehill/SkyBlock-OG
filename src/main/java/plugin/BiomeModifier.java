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
import org.jetbrains.annotations.NotNull;


public final class BiomeModifier extends BiomeProvider {
    @NotNull
    public Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
        Intrinsics.checkNotNullParameter(worldInfo, "worldInfo");
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 6);
        generator.setScale(0.01);
        return Biome.OCEAN;
    }

    @NotNull
    public List getBiomes(@NotNull WorldInfo worldInfo) {
        Intrinsics.checkNotNullParameter(worldInfo, "worldInfo");
        Biome[] biome  = new Biome[]{Biome.OCEAN};
        return List.of(biome);
    }
}
