package plugin;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

public final class GenerationModifier extends ChunkGenerator {
    public void generateBedrock(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkGenerator.ChunkData chunkData) {
        Intrinsics.checkNotNullParameter(worldInfo, "worldInfo");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(chunkData, "chunkData");

        for(int x = -64; x < 320; ++x) {
            for(int z = -64; z < 320; ++z) {
                chunkData.setBlock(x, chunkData.getMinHeight(), z, Material.AIR);
            }
        }

    }

    public void generateSurface(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkGenerator.ChunkData chunkData) {
        Intrinsics.checkNotNullParameter(worldInfo, "worldInfo");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(chunkData, "chunkData");

        for(int x = -64; x < 320; ++x) {
            for(int z = -64; z < 320; ++z) {
                chunkData.setBlock(x, chunkData.getMinHeight(), z, Material.AIR);
            }
        }

    }

    public boolean shouldGenerateCaves() {
        return false;
    }

    public boolean shouldGenerateMobs() {
        return false;
    }

    public boolean shouldGenerateDecorations() {
        return false;
    }

    public boolean shouldGenerateStructures() {
        return true;
    }

    public boolean shouldGenerateNoise() {
        return false;
    }
}
