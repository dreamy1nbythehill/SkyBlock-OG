package plugin.commands;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class island implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @Nullable String[] args) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(label, "label");
        if (!(sender instanceof Player)) {
            sender.sendMessage("You aren't a Player!");
            return true;
        } else {
            sender.sendMessage("Generating island....");
            return true;
        }
    }
}
