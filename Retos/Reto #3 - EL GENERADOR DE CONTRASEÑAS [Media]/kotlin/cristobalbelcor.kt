fun main() {
    println(passwordGenerator()) // Ejemplo básico solo letras minusculas
    println(passwordGenerator(tamano = 16)) // Contraseña de longitud máxima
    println(passwordGenerator(tamano = 1)) // Contraseña de longitud mínima
    println(passwordGenerator(tamano = 22)) // Contraseña con longitud inválida (debe ser 16)
    println(passwordGenerator(tamano = 12, mayusculas = true)) // Contraseña con mayúsculas
    println(passwordGenerator(tamano = 12, mayusculas = true, numeros = true)) // Contraseña con mayúsculas y números
    println(passwordGenerator(tamano = 12, mayusculas = true, numeros = true, signos = true)) // Contraseña con todos los parámetros
}

private fun passwordGenerator(
    tamano: Int = 8,
    mayusculas: Boolean = false,
    numeros: Boolean = false,
    signos: Boolean = false
): String {

    // Validar parámetros
    val finalLength = when {
        tamano < 8 -> 8
        tamano > 16 -> 16
        else -> tamano
    }

    // Generar el conjunto de caracteres permitido
    val characters = mutableListOf<Char>()
    characters += ('a'..'z') // Letras minúsculas
    if (mayusculas) characters += ('A'..'Z') // Letras mayúsculas
    if (numeros) characters += ('0'..'9') // Números

    // Agregar símbolos usando rangos ASCII para evitar caracteres confusos
    if (signos) {
        characters += (33..47).map { it.toChar() } // Símbolos del 33 al 47 en ASCII
        characters += (58..64).map { it.toChar() } // Símbolos del 58 al 64 en ASCII
        characters += (91..96).map { it.toChar() } // Símbolos del 91 al 96 en ASCII
        characters += (123..126).map { it.toChar() } // Símbolos del 123 al 126 en ASCII
    }

    // Generar contraseña
    val passwordBuilder = StringBuilder(finalLength)
    repeat(finalLength) {
        passwordBuilder.append(characters.random())
    }

    return passwordBuilder.toString()
}
