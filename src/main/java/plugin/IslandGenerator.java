package plugin;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IslandGenerator {

    public static void Generator(int x, int y, int z, @NotNull CommandSender player) throws IOException, WorldEditException {
        File schematic = new File(SkyBlockOG.Companion.getPlugin().getDataFolder(), "normal.schem");
        ClipboardFormat format = ClipboardFormats.findByFile(schematic);
        ClipboardReader reader = format.getReader(new FileInputStream(schematic));
        Clipboard clipboard = reader.read();

        try (
                EditSession editSession = WorldEdit.getInstance().newEditSession((World) player.getWorld())) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(x, y, z))
                    // configure here
                    .build();
            Operations.complete(operation);
        }

    }
}
