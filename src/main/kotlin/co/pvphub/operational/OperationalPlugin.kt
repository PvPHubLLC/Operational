package co.pvphub.operational

import co.pvphub.operational.environment.bukkit.scheduling.BukkitScheduler
import co.pvphub.operational.types.Scheduler
import com.google.inject.Inject
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.file.Path
import java.util.logging.Logger

// TODO impl for velocity AND bukkit
class OperationalPlugin() : JavaPlugin() {
    lateinit var environment: Environment
        private set

    @Inject constructor(
        server: ProxyServer,
        logger: Logger,
        @DataDirectory dataDirectory: Path
    ) : this()

    override fun onEnable() {
        instance = this
        environment = Environment.BUKKIT
        saveDefaultConfig()
        // Create initial folders
        val addons = File("${dataFolder}/addons/")
        if (!addons.exists()) {
            addons.createNewFile()
            // Create example addons
        }
        // Load all scripts
    }

    companion object {
        private lateinit var instance: OperationalPlugin
        fun get() = instance
        fun scheduler() = instance.environment.scheduler
    }

}

enum class Environment(
    val id: String,
    val scheduler: Scheduler,
) {
    BUKKIT("bukkit", BukkitScheduler()),
    VELOCITY("velocity", BukkitScheduler())
}