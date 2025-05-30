package plugin;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extension.platform.Actor;
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
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IslandGenerator {

    public static void Generator(int x, int y, int z, Player player) throws IOException {
        Clipboard clipboard;
        com.sk89q.worldedit.world.World placeWorld = BukkitAdapter.adapt(player.getWorld());
        ClipboardFormat format = ClipboardFormats.findByFile(new File(SkyBlockOG.getPlugin().getDataFolder(), "normal.schem"));
        try (ClipboardReader reader = format.getReader(new FileInputStream(new File(SkyBlockOG.getPlugin().getDataFolder(), "normal.schem")))) {
            clipboard = reader.read();
        }
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(placeWorld)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(x, y, z))
                    .ignoreAirBlocks(true)
                    .build();
            Operations.complete(operation);
        } catch (WorldEditException e) {
            throw new RuntimeException(e);
        }
      /*  Clipboard clipboard;
        File schematic = new File(SkyBlockOG.getPlugin().getDataFolder(), "normal.schem");
        System.out.println(schematic);
       // ClipboardFormat format = ClipboardFormats.findByFile(schematic);
        ClipboardFormat format = ClipboardFormats.findByFile(schematic);
        try (ClipboardReader reader = format.getReader(new FileInputStream(schematic))) {
            clipboard = reader.read();
        }
        try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession((World) world, -1)) {
            Operation operation = new ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(BlockVector3.at(x, y, z))
                    .ignoreAirBlocks(false)
                    .build();
            Operations.complete(operation);
        } catch (WorldEditException e) {
            throw new RuntimeException(e);
        }*/


    }
}
