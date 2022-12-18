package co.pvphub.operational.environment.bukkit.scheduling

import co.pvphub.operational.types.ScheduledTask
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask

class BukkitScheduledTask(val task: (ScheduledTask) -> Unit) : ScheduledTask {
    override fun task() = task

    private var async = false
    private var delay = 0L
    private var repeat = 0L
    private lateinit var bTask: BukkitTask

    override fun async(value: Boolean) = run { async = value; this }
    override fun async() = async

    override fun delay(delay: Long) = run { this.delay = delay; this }
    override fun delay() = delay

    override fun repeat(repeat: Long) = run { this.repeat = repeat; this }
    override fun repeat() = repeat

    override fun cancel() = run { bTask.cancel(); this }
    override fun cancelled() = bTask.isCancelled

    override fun schedule(plugin: Any) {
        val plugin = plugin as JavaPlugin
        val scheduler = Bukkit.getScheduler()
        if (repeat > 0L) {
            // We should schedule a repeating task
            if (async) scheduler.runTaskTimerAsynchronously(plugin, { i -> run(i) }, delay, repeat)
            else scheduler.runTaskTimer(plugin, { i -> run(i) }, delay, repeat)
        } else if (delay > 0L) {
            if (async) scheduler.runTaskLaterAsynchronously(plugin, { i -> run(i) }, delay)
            else scheduler.runTaskLater(plugin, { i -> run(i) }, delay)
        } else {
            if (async) scheduler.runTaskAsynchronously(plugin) { i -> run(i) }
            else scheduler.runTask(plugin) { i -> run(i) }
        }
    }

    private val run: (bTask: BukkitTask) -> Unit = { bTask ->
        this.bTask = bTask
        task(this)
    }
}