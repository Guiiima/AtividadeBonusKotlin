class AlunoNome(val nome: String) : Comparable<AlunoNome> {
    override fun compareTo(other: AlunoNome): Int {
        return nome.compareTo(other.nome)
    }
}
fun main() {
    val alunos = mutableListOf<AlunoNome>()

    for (i in 1..10) {
        println("Cadastro do aluno ${i}:")
        print("Nome: ")
        val nome = readLine() ?: ""
        alunos.add(AlunoNome(nome))
    }
    val listaAlfabetica = alunos.sorted()

    println("\nAlunos cadastrados:")
    for (aluno in listaAlfabetica) {
        println(aluno.nome)
    }
}
