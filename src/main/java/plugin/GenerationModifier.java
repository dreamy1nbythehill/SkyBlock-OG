package plugin;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;


public final class GenerationModifier extends ChunkGenerator {
    @Override
    public void generateBedrock(WorldInfo worldInfo, Random random, int chunkX, int chunkZ,  ChunkGenerator.ChunkData chunkData) {
        Intrinsics.checkNotNullParameter(worldInfo, "worldInfo");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(chunkData, "chunkData");

        for(int x = -64; x < 320; ++x) {
            for(int z = -64; z < 320; ++z) {
                chunkData.setBlock(x, chunkData.getMinHeight(), z, Material.AIR);
            }
        }

    }
    @Override
    public void generateSurface( WorldInfo worldInfo,  Random random, int chunkX, int chunkZ,  ChunkGenerator.ChunkData chunkData) {

        for(int x = -64; x < 320; ++x) {
            for(int z = -64; z < 320; ++z) {
                chunkData.setBlock(x, chunkData.getMinHeight(), z, Material.AIR);
            }
        }

    }
    @Override
    public boolean shouldGenerateCaves() {
        return false;
    }
@Override
    public boolean shouldGenerateMobs() {
        return false;
    }
@Override
    public boolean shouldGenerateDecorations() {
        return false;
    }
@Override
    public boolean shouldGenerateStructures() {
        return true;
    }
    @Override
    public boolean shouldGenerateNoise() {
        return false;
    }
}
