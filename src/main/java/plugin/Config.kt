// This is free and unencumbered software released into the public domain.
// Author: dreamy1nbytheill

package plugin

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
object Config {
    private lateinit var config: FileConfiguration
    private lateinit var file: File

    fun load() {
        file = File(SkyBlockOG.plugin.dataFolder, "config.yml")
        if (!file.exists()) {
            SkyBlockOG.plugin.saveDefaultConfig()
        }

        config = YamlConfiguration.loadConfiguration(file)

        this.save()
    }

    private fun save() {
        config.save(file)
    }

   /*fun getTemplateBool(): Boolean {
        return config.get("templateBool") as Boolean
    }

    fun getTemplateDouble(): Double {
        return config.get("templateDouble") as Double
    }*/

    fun getPostgresUser(): String {
        return config.get("postgresUser") as String
    }
    fun getPostgresUserPassword(): String {
        return config.get("postgresUserPassword") as String
    }
    fun getPostgresUrl(): String {
        return config.get("postgresUrl") as String
    }
    fun getPostgresPort(): String {
        return config.get("postgresPort") as String
    }
}
