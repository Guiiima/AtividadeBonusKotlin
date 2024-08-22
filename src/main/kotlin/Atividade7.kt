class Voo(val numeroDoVoo: String, assentos: Int) {
    private val assentosDisponiveis = IntArray(assentos) { it + 1 }
    fun verificarDisponibilidade(assento: Int): Boolean {
        return assento in assentosDisponiveis
    }
    fun reservarAssento(assento: Int): Boolean {
        val index = assentosDisponiveis.indexOf(assento)
        if (index != -1) {
            assentosDisponiveis[index] = 0
            return true
        }
        return false
    }
    fun listarAssentosDisponiveis(): String {
        return assentosDisponiveis.filter { it != 0 }.joinToString(", ")
    }
}
fun main() {
    val voo = Voo("1234", 10)

    while (true) {
        println("\nSistema de Reservas do Voo ${voo.numeroDoVoo}")
        println("1. Verificar disponibilidade de um assento")
        println("2. Reservar um assento")
        println("3. Listar assentos disponíveis")
        println("4. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Digite o numero do assento para verificar: ")
                val assento = readLine()?.toIntOrNull() ?: 0
                if (voo.verificarDisponibilidade(assento)) {
                    println("O assento $assento está disponível")
                } else {
                    println("O assento $assento não está disponível")
                }
            }
            2 -> {
                print("Digite o numero do assento para reservar: ")
                val assento = readLine()?.toIntOrNull() ?: 0
                if (voo.reservarAssento(assento)) {
                    println("Assento $assento reservado com sucesso")
                } else {
                    println("O assento $assento não está disponível para reserva")
                }
            }
            3 -> {
                println("Assentos disponíveis: ${voo.listarAssentosDisponiveis()}")
            }
            4 -> {
                println("Saindo do sistema.")
                break
            }
            else -> {
                println("Opção inválida. Tente novamente.")
            }
        }
    }
}
