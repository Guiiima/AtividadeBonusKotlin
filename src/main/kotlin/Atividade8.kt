class Produto(
    val nome: String,
    var quantidade: Int,
    val nivelMinimo: Int,
    private val nivelMaximo: Int
) {
    fun verificarQuantidade() {
        if (quantidade < nivelMinimo) {
            println("A quantidade do produto '$nome' está abaixo do nível mínimo")
            reporEstoque()
        } else {
            println("A quantidade do produto '$nome' está adequada")
        }
    }
    private fun reporEstoque() {
        println("Repondo estoque do produto '$nome'...")
        quantidade = nivelMaximo
        println("Estoque do produto '$nome' reabastecido para o nível máximo de $nivelMaximo unidades.")
    }
}
fun main() {
    val produtos = mutableListOf<Produto>()
    for (i in 1..5) {
        println("Cadastro do Produto $i:")
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Quantidade atual: ")
        val quantidade = readLine()?.toIntOrNull() ?: 0
        print("Nível mínimo: ")
        val nivelMinimo = readLine()?.toIntOrNull() ?: 0
        print("Nível máximo: ")
        val nivelMaximo = readLine()?.toIntOrNull() ?: 0

        val produto = Produto(nome, quantidade, nivelMinimo, nivelMaximo)
        produtos.add(produto)
    }
    println("\nVerificando quantidades e recolocando estoque se precisso:")
    for (produto in produtos) {
        produto.verificarQuantidade()
    }
}
