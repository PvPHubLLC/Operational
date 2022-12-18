package co.pvphub.operational.types

interface ScheduledTask {
    fun task() : (ScheduledTask) -> Unit

    /**
     * Determines if the function will run
     * async or not.
     *
     * @param value if the func is async
     * @return if the func is async
     */
    fun async(value: Boolean) : ScheduledTask
    fun async() : Boolean

    /**
     * Initial delay of execution in ticks.
     *
     * @param delay
     */
    fun delay(delay: Long) : ScheduledTask
    fun delay() : Long

    fun repeat(repeat: Long) : ScheduledTask
    fun repeat() : Long

    /**
     * Call [cancel] in order to stop the function from running
     */
    fun cancel() : ScheduledTask
    fun cancelled() : Boolean

    /**
     * Call this to finally schedule the task
     */
    fun schedule(plugin: Any)

}