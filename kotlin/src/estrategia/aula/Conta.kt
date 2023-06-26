package estrategia.aula

open class Conta (saldo: Double = 0.0) {
    var titular: String =""
    var saldo = saldo
        private set(value){
            println("alterando o valor de saldo antigo $saldo novo $value")
            field = value
        }

    open fun extrato(){
        println("o seu saldo é $saldo")
    }

    fun depositar(valor:Double){
        this.saldo+=valor
    }
}