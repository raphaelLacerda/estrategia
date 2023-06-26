package estrategia.banco

open class Conta(saldo: Double = 0.0) {

    var titular: String = "";
    var saldo = saldo
//        private set(value) {
//            println("alterando o saldo com $value")
//            field = value;
//        }
        set(value) {
            println("alterando o saldo com $value")
            field = value;
        }

    open fun extrato() {
        println("O saldo total é $saldo")
    }
}