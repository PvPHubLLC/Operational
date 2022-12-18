package co.pvphub.operational.api

@Target(AnnotationTarget.FUNCTION)
annotation class OpFunction(
    val regexes: Array<String> = []
)

interface OpExtension {
    fun environment() = OpExtensionEnvironment.any()
}