fun main() {
    val temperaturas = DoubleArray(30)
    println("Digite as temperaturas diaria para um mês (30 dias):")
    for (i in 0 until temperaturas.size) {
        print("Dia ${i + 1}: ")
        val temp = readLine()?.toDoubleOrNull()
        if (temp != null) {
            temperaturas[i] = temp
        } else {
            println("Entrada da temperatura incorreto, portando sera considerado 0.0°C.")
            temperaturas[i] = 0.0
        }
    }
    val mediaTemperatura = temperaturas.average()
    val temperaturaMaxima = temperaturas.maxOrNull() ?: 0.0
    val temperaturaMinima = temperaturas.minOrNull() ?: 0.0

    val diasTemperaturaMaxima = temperaturas
        .withIndex()
        .filter { it.value == temperaturaMaxima }
        .map { it.index + 1 }

    val diasTemperaturaMinima = temperaturas
        .withIndex()
        .filter { it.value == temperaturaMinima }
        .map { it.index + 1 }
    println("\nTemperatura média do mes: %.2f°C".format(mediaTemperatura))
    println("Temperatura máxima do mes: %.2f°C".format(temperaturaMaxima))
    println("Temperatura mínima do mes: %.2f°C".format(temperaturaMinima))

    println("Dias com a temperatura maxima (${temperaturaMaxima}°C): ${diasTemperaturaMaxima.joinToString()}")
    println("Dias com a temperatura minima (${temperaturaMinima}°C): ${diasTemperaturaMinima.joinToString()}")
}
