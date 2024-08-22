class Atividade1 {
    class VerificadorPrimo(val num: Int) {
        fun isPrimo(): Boolean {
            if (num <= 1) return false
            if (num == 2) return true
            if (num % 2 == 0) return false

            for (i in 3..Math.sqrt(num.toDouble()).toInt() step 2) {
                if (num % i == 0) return false
            }
            return true
        }
    }
}
fun main() {
    println("Informe o número para saber se é primo ou não: ")
    val num = readLine()?.toIntOrNull() ?: return println("Entrada inválida")
    val verificador = Atividade1.VerificadorPrimo(num)

    if (verificador.isPrimo()) {
        println("É primo")
    } else {
        println("Não é primo")
    }
}