package estrategia.banco

import java.time.LocalDate

data class Cliente(val nome: String, val dataNascimento: LocalDate){
    var telefone: String? = null
}

