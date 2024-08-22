class Aluno(val nome: String, val notas: Array<Double>) {
    fun calcularMedia(): Double {
        if (notas.isEmpty()) return 0.0
        return notas.sum() / notas.size
    }

    fun foiAprovado(): Boolean {
        return calcularMedia() >= 7.0
    }
}

fun main() {
    val alunos = mutableListOf<Aluno>()
    repeat(5) { i ->
        println("Cadastro do aluno ${i + 1}:")
        print("Nome: ")
        val nome = readLine() ?: ""
        val notas = mutableListOf<Double>()
        for (j in 1..3) {
            var notaValida = false
            while (!notaValida) {
                print("Nota $j: ")
                val nota = readLine()?.toDoubleOrNull()
                if (nota != null && nota in 0.0..10.0) {
                    notas.add(nota)
                    notaValida = true
                } else {
                    println("Nota inválida, deve estar entre 0 e 10. Tente novamente.")
                }
            }
        }
        alunos.add(Aluno(nome, notas.toTypedArray()))
    }

    println("\nResultados:")
    alunos.forEach { aluno ->
        val media = aluno.calcularMedia()
        val status = if (aluno.foiAprovado()) "Aprovado" else "Reprovado"
        println("Nome: ${aluno.nome}")
        println("Média: $media")
        println("Status: $status\n")
    }
}
