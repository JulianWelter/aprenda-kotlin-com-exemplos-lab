import entities.Aluno
import entities.ConteudoEducacional
import entities.Formacao
import enums.Assinatura
import enums.Nivel
import extensionFunctions.addAll
import factories.FormacaoFactory.Companion.criarFormacao

fun main() {
    val conteudoEducacional = listOf(ConteudoEducacional("Introdução"), ConteudoEducacional("Exercício"))
    val controle = mutableListOf<Formacao>()
    val logica = criarFormacao("logica")
    val kotlin = criarFormacao("kotlin", conteudoEducacional)
    val java = criarFormacao("java")
    val php = criarFormacao("php", conteudoEducacional)
    val docker = criarFormacao("docker")

    controle.addAll(logica, kotlin, java, php, docker)

    val javeiro = Aluno("javeiro", Assinatura.GLOBAL, nivel = Nivel.INTERMEDIARIO)
    val javeiro2 = Aluno("javeiro2", Assinatura.FREE, nivel = Nivel.INTERMEDIARIO)
    val javeiroEvoluido = Aluno("javeiroEvoluido", Assinatura.GLOBAL, nivel = Nivel.AVANCADO)
    val caraDoPhp = Aluno("caraDoPhp")
    val oServidorCaiu = Aluno("oServidorCaiu")
    val vouFicarRicoComTI = Aluno("vouFicarRicoComTI")

    java.matricular(javeiro, javeiro2, javeiroEvoluido)
    kotlin.matricular(javeiroEvoluido)
    php.matricular(caraDoPhp)
    logica.matricular(vouFicarRicoComTI)
    docker.matricular(oServidorCaiu)

    println("\nListando incritos")
    controle.forEach { it.listarInscritos() }.also { println("Fim da listagem de inscritos") }
    println("\nListando conteudos")
    controle.forEach { it.listarConteudos() }.also { println("Fim da listagem de conteudos") }

    println("\nVerificando se a formação java contem o aluno \"javeiroEvoluido\"")
    java.printEstaInscrito(javeiroEvoluido)
    println("\nRemovendo o aluno \"javeiroEvoluido\" da formação java")
    java.removerInscrito(javeiroEvoluido)
    println("\nVerificando se a formação java contem o aluno \"javeiroEvoluido\"")
    java.printEstaInscrito(javeiroEvoluido)
    println("\nListando incritos java")
    java.listarInscritos().also { println("Fim da listagem de inscritos java") }
}

