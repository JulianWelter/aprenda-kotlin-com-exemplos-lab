package entities

import enums.Nivel

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivelRequerido: Nivel = Nivel.BASICO)