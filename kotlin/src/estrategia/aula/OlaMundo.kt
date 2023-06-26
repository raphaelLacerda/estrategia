package estrategia.aula

import java.time.LocalDate
import kotlin.reflect.typeOf

fun main(){
    val c1 = Conta()
    c1.depositar(30.5)
    print(c1.extrato())
    val c2 = ContaPoupanca()
    c2.depositar(54.2)
    println(c2.extrato())

    var c3 = ContaCorrente()
    c3.depositar(500.34)
    println(c3.extrato())

}