package co.pvphub.operational.environment.velocity.scheduler

import co.pvphub.operational.types.ScheduledTask
import com.velocitypowered.api.proxy.ProxyServer
import java.util.concurrent.TimeUnit

class VelocityScheduledTask(val proxy: ProxyServer, val task: (ScheduledTask) -> Unit) : ScheduledTask {
    override fun task() = task

    private var async = false
    private var delay = 0L
    private var repeat = 0L
    private lateinit var bTask: com.velocitypowered.api.scheduler.ScheduledTask

    override fun async(value: Boolean) = run { async = value; this }
    override fun async() = async

    override fun delay(delay: Long) = run { this.delay = delay; this }
    override fun delay() = delay

    override fun repeat(repeat: Long) = run { this.repeat = repeat; this }
    override fun repeat() = repeat

    override fun cancel() = run { bTask.cancel(); this }
    override fun cancelled() = false

    override fun schedule(plugin: Any) {
        // todo impl async
        // Delay and repeat are in ticks so we need to convert them to MS (x50)
        proxy.scheduler.buildTask(plugin) { t ->
            this.bTask = t
            task(this)
        }.delay(delay * 50, TimeUnit.MILLISECONDS)
            .repeat(repeat * 50, TimeUnit.MILLISECONDS)
            .schedule()
    }
}