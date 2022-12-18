package co.pvphub.operational.environment.bukkit.scheduling

import co.pvphub.operational.types.ScheduledTask
import co.pvphub.operational.types.Scheduler

class BukkitScheduler : Scheduler {

    override fun runTask(task: ScheduledTask, plugin: Any) = task.schedule(plugin)

    override fun task(task: (ScheduledTask) -> Unit) = BukkitScheduledTask(task)

}