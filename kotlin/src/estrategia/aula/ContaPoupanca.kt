package estrategia.aula

class ContaPoupanca : Conta() {

    override fun extrato() {
        println("Conta poucanca $saldo")
    }
}