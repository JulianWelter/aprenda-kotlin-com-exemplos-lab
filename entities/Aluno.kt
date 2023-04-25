package entities

import enums.Assinatura
import enums.Nivel

class Aluno(name: String, var assinatura: Assinatura = Assinatura.FREE, var nivel: Nivel = Nivel.BASICO) :
    Usuario(name)