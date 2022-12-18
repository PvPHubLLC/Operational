package co.pvphub.operational.types

interface Scheduler {

    fun runTask(task: ScheduledTask, plugin: Any)

    fun task(task: (ScheduledTask) -> Unit) : ScheduledTask

}