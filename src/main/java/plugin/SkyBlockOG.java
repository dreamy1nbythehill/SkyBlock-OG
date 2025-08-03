package plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.commands.island;

import java.io.IOException;
import java.util.logging.Level;

public final class SkyBlockOG extends JavaPlugin {
    private static SkyBlockOG plugin;
    private static Plugin worldedit = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit-Bukkit");

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        getLogger().log(Level.WARNING, "CustomChunkGenerator is used!");
        return new GenerationModifier(); // Return an instance of the chunk generator we want to use.
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull String worldName, @Nullable String id) {
        return new BiomeModifier();
    }

    public void onEnable() {
        plugin = this;
        this.getServer().getPluginManager().registerEvents((Listener)(new Listeners()), (Plugin)this);
        Config.INSTANCE.load();
        PluginCommand islandCommand = this.getCommand("island");
        if (islandCommand != null) {
            islandCommand.setExecutor((CommandExecutor)(new island()));
        }

    }

        public final Plugin getWorldedit() {
            return SkyBlockOG.worldedit;
        }

        public final void setWorldedit(Plugin wedit) {
            SkyBlockOG.worldedit = wedit;
        }

    public static SkyBlockOG getPlugin() {
        return plugin;
    }
}
