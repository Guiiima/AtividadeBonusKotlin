class Atividade2 {
    class VerificarQuantasPalavrasParagrafo(val paragrafo: String) {
        fun verificarQuantidadePalavras(): Int {
            if (paragrafo.isBlank()) return 0
            return paragrafo.split("\\s+".toRegex()).size
        }
    }
}
fun main() {
    println("Informe um parágrafo para contar as palavras: ")
    val paragrafo = readLine() ?: return println("Entrada inválida")
    val contador = Atividade2.VerificarQuantasPalavrasParagrafo(paragrafo)
    println("Número de palavras no parágrafo: ${contador.verificarQuantidadePalavras()}")
}