package entities

import enums.Assinatura
import enums.Nivel

data class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
    val nivel: Nivel,
    val assinaturaMinima: Assinatura
) {

    private val inscritos = mutableSetOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        for (aluno in alunos) {
            if (podeSeMatricular(aluno)) {
                inscritos.add(aluno)
            } else {
                println("Não foi possivel cadastrar o aluno: ${aluno.nome} no curso $nome")
            }
        }
        //TODO("Utilize o parâmetro $usuarios para simular uma matrícula (usar a lista de $inscritos).")
    }

    private fun poassuiAssinaturaRequerida(aluno: Aluno) = aluno.assinatura.indice >= assinaturaMinima.indice
    private fun poassuiNivelRequerido(aluno: Aluno) = aluno.nivel.indice >= nivel.indice
    private fun podeSeMatricular(aluno: Aluno) = poassuiAssinaturaRequerida(aluno) && poassuiNivelRequerido(aluno)

    fun listarInscritos() {
        print("Alunos $nome: ")
        inscritos.forEachIndexed { index, it ->
            print("${it.nome}${if (index != inscritos.size - 1) ", " else ""}")
        }
        println()
    }

    fun listarConteudos() {
        print("Conteudos $nome: ")
        conteudos.forEachIndexed { index, it ->
            print("${it.nome}${if (index != conteudos.size - 1) ", " else ""}")
        }
        println()
    }

    fun removerInscrito(usuario: Usuario)= inscritos.remove(usuario)
    private fun estaInscrito(usuario: Usuario): Boolean = inscritos.contains(usuario)

    fun printEstaInscrito(usuario: Usuario)= println("${usuario.nome} esta inscrito no $nome? ${if (estaInscrito(usuario)) "Sim" else "Não"}!")

}
