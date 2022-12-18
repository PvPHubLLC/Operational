package co.pvphub.operational.environment.velocity.scheduler

import co.pvphub.operational.types.ScheduledTask
import co.pvphub.operational.types.Scheduler
import com.velocitypowered.api.proxy.ProxyServer

class VelocityScheduler(val proxy: ProxyServer) : Scheduler {

    override fun runTask(task: ScheduledTask, plugin: Any) {
        task.schedule(plugin)
    }

    override fun task(task: (ScheduledTask) -> Unit): ScheduledTask = VelocityScheduledTask(proxy, task)
}