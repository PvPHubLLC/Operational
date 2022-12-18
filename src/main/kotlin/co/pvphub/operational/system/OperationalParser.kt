package co.pvphub.operational.system

import java.io.File

object OperationalParser {

    fun parse(path: String) = parse(File(path))

    fun parse(file: File) = parseString(file.readText())

    fun parseString(string: String) : OperationalScript? {
        return null
    }

}