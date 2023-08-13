enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String, var email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
         	if (inscritos.contains(usuario)) {
                println("O(a) usuário ${usuario.nome} já está matrículado(a) nessa formação!")
                return
            }

            inscritos.add(usuario)
            println("O(a) usuário ${usuario.nome} foi matriculado(a) com sucesso na formação $nome")   
        }
    }
}

fun main() {
    val aluno = Usuario("Hugo", "hugorplobo@gmail.com")
    val aluno2 = Usuario("Joana", "joana123@gmail.com")
    
    val aula1 = ConteudoEducacional("Aula 1", 60)
    val curso1 = Formacao("Curso 1", Nivel.BASICO, listOf(aula1))
    
    curso1.matricular(aluno, aluno2)
}
