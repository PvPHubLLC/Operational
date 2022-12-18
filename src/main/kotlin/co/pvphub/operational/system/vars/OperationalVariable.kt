package co.pvphub.operational.system.vars

class OperationalVariable<T>(val name: String, var value: T? = null) {

    companion object {
        val regex = "\\[(\\w|\\d|\\.|::)+]|(\\w|\\d|\\.|::)+".toRegex()
    }
}