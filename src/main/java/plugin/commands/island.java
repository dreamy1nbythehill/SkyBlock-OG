package plugin.commands;

import com.sk89q.worldedit.WorldEditException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.IslandGenerator;

import java.io.IOException;

public final class island implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @Nullable String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You aren't a Player!");
            return true;
        } else {
            sender.sendMessage("Generating island....");
            int[] placeHolderNum = {500, 500, 50};
            try {
                IslandGenerator.Generator(placeHolderNum[0], placeHolderNum[1], placeHolderNum[2], sender);
            } catch (IOException | WorldEditException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }
}
