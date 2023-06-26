package estrategia.banco

class ContaPoupanca : Conta() {

    override fun extrato() {
        println ("Extrato da conta Poupanca $saldo")
    }
}