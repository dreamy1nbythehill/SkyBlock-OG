package plugin.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import plugin.IslandGenerator

class island : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendMessage("You aren't a Player!")
            return true

        }

        else {
            //add subcommand for island generation
            //check if player already has island
            sender.sendMessage("Generating island....")


            return true


        }
    }
}