package co.pvphub.operational.utils

import co.pvphub.operational.OperationalPlugin
import co.pvphub.operational.types.ScheduledTask

fun async(plugin: Any, task: (ScheduledTask) -> Unit) =
    OperationalPlugin.scheduler().task(task).async(true).schedule(plugin)

fun asyncDelayed(plugin: Any, delay: Long, task: (ScheduledTask) -> Unit) =
    OperationalPlugin.scheduler().task(task).async(true).delay(delay).schedule(plugin)

fun asyncRepeat(plugin: Any, period: Long, delay: Long = 0L, task: (ScheduledTask) -> Unit) =
    OperationalPlugin.scheduler().task(task).async(true).repeat(period).delay(delay).schedule(plugin)

fun sync(plugin: Any, task: (ScheduledTask) -> Unit) = OperationalPlugin.scheduler().task(task).schedule(plugin)
fun syncDelayed(plugin: Any, delay: Long, task: (ScheduledTask) -> Unit) =
    OperationalPlugin.scheduler().task(task).delay(delay).schedule(plugin)
fun syncRepeat(plugin: Any, period: Long, delay: Long = 0L, task: (ScheduledTask) -> Unit) =
    OperationalPlugin.scheduler().task(task).repeat(period).delay(delay).schedule(plugin)