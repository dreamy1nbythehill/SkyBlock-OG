// This is free and unencumbered software released into the public domain.
// Author: dreamy1nbythehill
package plugin

import org.bukkit.Bukkit
import org.bukkit.generator.BiomeProvider
import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.java.JavaPlugin
import plugin.commands.island


// Extending this class is standard bukkit boilerplate for any plugin, or else the server software won't load the classes.
class KotlinTemplateOG : JavaPlugin() {

    companion object {
        lateinit var plugin: JavaPlugin
        var worldedit = Bukkit.getServer().pluginManager.getPlugin("WorldEdit-Bukkit")
    }

    override fun getDefaultWorldGenerator(worldName: String, id: String?): ChunkGenerator {
        return GenerationModifier()
    }

    override fun getDefaultBiomeProvider(worldName: String, id: String?): BiomeProvider {
        return BiomeModifier()
    }


    override fun onEnable() {
        plugin = this
        server.pluginManager.registerEvents(Listeners(), this)
        Config.load()
        this.getCommand("island")?.setExecutor(island())




    }

    }





