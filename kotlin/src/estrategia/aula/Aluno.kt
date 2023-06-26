package estrategia.aula
import java.time.LocalDate

data class Aluno (val nome: String,
                  val dataNascimento: LocalDate) {
    var telefone: String? = null
}