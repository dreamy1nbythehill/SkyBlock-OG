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

public final class SkyBlockOG extends JavaPlugin {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    public static JavaPlugin plugin;
    @Nullable
    private static Plugin worldedit = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit-Bukkit");

    @NotNull
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        Intrinsics.checkNotNullParameter(worldName, "worldName");
        return (ChunkGenerator)(new GenerationModifier());
    }

    @NotNull
    public BiomeProvider getDefaultBiomeProvider(@NotNull String worldName, @Nullable String id) {
        Intrinsics.checkNotNullParameter(worldName, "worldName");
        return (BiomeProvider)(new BiomeModifier());
    }

    public void onEnable() {
        Companion.setPlugin(this);
        this.getServer().getPluginManager().registerEvents((Listener)(new Listeners()), (Plugin)this);
        try {
            Config.INSTANCE.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PluginCommand var1 = this.getCommand("island");
        if (var1 != null) {
            var1.setExecutor((CommandExecutor)(new island()));
        }

    }


    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final JavaPlugin getPlugin() {
            JavaPlugin var1 = SkyBlockOG.plugin;
            if (var1 != null) {
                return var1;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                return null;
            }
        }

        public final void setPlugin(@NotNull JavaPlugin var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            SkyBlockOG.plugin = var1;
        }

        @Nullable
        public final Plugin getWorldedit() {
            return SkyBlockOG.worldedit;
        }

        public final void setWorldedit(@Nullable Plugin var1) {
            SkyBlockOG.worldedit = var1;
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
