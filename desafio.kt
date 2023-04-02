enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val name: String, val telefone: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: List<Usuario>) {
        for (aluno in usuario){
            inscritos.filter{ it -> it.telefone == aluno.telefone}.also { response ->
                with(aluno){
                    if(response.isEmpty()) {
                        inscritos.add(aluno)
                        println("Aluno $name matriculado com sucesso!")
                    } else {
                        println("Aluno $name ja esta matriculado!")
                    }
                }
            }
        }
    }
}

fun main() {
    val conteudoBasicoKotlin = listOf(ConteudoEducacional("Types"),ConteudoEducacional("Null safety"))
    val conteudoIntermediarioKotlin = listOf(ConteudoEducacional("Classes"),ConteudoEducacional("Classes Especiais"))
    val conteudoAvancadoKotlin = listOf(ConteudoEducacional("Funcoes"),ConteudoEducacional("Escopo de Funcoes"))

    val formacaoBasicaKotlin = Formacao("Kotlin", Nivel.BASICO, conteudoBasicoKotlin)
    val formacaoIntermediariaKotlin = Formacao("Kotlin", Nivel.INTERMEDIARIO, conteudoIntermediarioKotlin)
    val formacaoAvancadaKotlin = Formacao("Kotlin", Nivel.AVANCADO, conteudoAvancadoKotlin)

    val usuariosNivelBasico = listOf(Usuario("Joao", "11999999999"))
    val usuariosNivelIntermediario = listOf(
        Usuario("Maria", "11000000000"), Usuario("Jose", "11888888888"), Usuario("Jose", "11888888888")
    )

    formacaoBasicaKotlin.matricular(usuariosNivelBasico)
    formacaoIntermediariaKotlin.matricular(usuariosNivelIntermediario)
}
