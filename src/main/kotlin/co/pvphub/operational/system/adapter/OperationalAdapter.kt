package co.pvphub.operational.system.adapter

abstract class OperationalAdapter {
    val regex = arrayListOf<Regex>()

    constructor()

    constructor(vararg regexes: Regex) {
        regex.addAll(regexes)
    }

}