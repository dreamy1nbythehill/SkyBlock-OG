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
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You aren't a Player!");
            return true;
        } else {
            int[] placeHolderNum = {500, 200, 500};
            sender.sendMessage("Generating island at " + placeHolderNum[0] + " " + placeHolderNum[1] + " " + placeHolderNum[2]);
            try {
                IslandGenerator.Generator(placeHolderNum[0], placeHolderNum[1], placeHolderNum[2], (Player) sender);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }
}
