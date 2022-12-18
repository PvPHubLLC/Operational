package co.pvphub.operational

import co.pvphub.operational.environment.bukkit.scheduling.BukkitScheduledTask
import co.pvphub.operational.environment.bukkit.scheduling.BukkitScheduler
import co.pvphub.operational.types.ScheduledTask
import co.pvphub.operational.types.Scheduler
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class OperationalPlugin : JavaPlugin() {
    lateinit var environment: Environment
        private set

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