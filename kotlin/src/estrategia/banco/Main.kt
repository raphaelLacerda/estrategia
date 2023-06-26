package estrategia.banco

import java.time.LocalDate

fun main() {
    var a = "ola mundo"
    println(a)
    a = "mundando"
    println(a)

    var c = Conta()

    c.saldo = 10.1

    print(c.extrato())

    var idade = 10
    println(idade)
    idade++
    ++idade
    println(idade)


    val contas = listOf(Conta(), Conta(), Conta())

    contas[0].saldo = 12.0
    contas[1].saldo = 24.0
    contas[2].saldo = 32.0


    contas.forEach { println(it.extrato()) }

    for (conta in contas) {
        println(conta.saldo)
    }

    var b: String? = "abc"
    b = null // ok


    println(b?.length)


    var c2 = ContaCorrente()
    c2.extrato()
    println(c2.saldo)

    var C2 = ContaCorrente()
    C2.extrato()

    var _open = ContaPoupanca()
    _open.extrato()

//
//    var nome = "rafa"
//    var nome2 = "rafa"
//    println(nome == nome2)
//    println(nome.equals(nome2))
//    println(nome === nome2)


    val _numeros1 = listOf(10,20,30)
    val numeros2 = listOf(10,20,30)

    println(_numeros1.equals(numeros2))
    println(_numeros1 == numeros2)
    println(_numeros1 === numeros2)

//
//    println("netflix".plus("rafa"))
}