let nome = "Raphael"
let sobrenome = "Lacerda"

var idade = 19
let (x, y) = (1, 2)


print(idade)
print(type(of: idade))

idade = idade + 1
//idade++

print(idade)


// ====================STRINGS
print (nome + " " + sobrenome)
print (nome.count)
print("Ola \(nome) sua idade é \(idade)")
for n in nome{
    print(n)
}

var c = "rafa henrique lacerda pinho"
c.uppercased()
print(c)
print(c.prefix(4))
print(c.prefix(c.count))
print(c.suffix(5))
print(c.hasPrefix("r"))

//swift 4
let start = c.index(c.startIndex, offsetBy: 5)
let end = c.index(c.endIndex, offsetBy: -6)
let range = start..<end
var subs = c[range]
print(subs)

//swift 5
print(c.suffix(22).prefix(16))





//------------------------- condicionais -----
if nome.count > 5{
    print("nome grande")
} else{
    print("nome pequeno")
}

//idade = 23

switch idade{
    
//case 10,11,12,13,14,15:
case 10...15:
    print("pode entrar")
case 16...20:
    print("pode sair")
case 21..<23:
    print("ferrou")
default:
    print("nao vai dar nada")
}


//------------------- LOOPS

let names = ["Anna", "Alex", "Brian", "Jack"]
for name in names {
    print("Hello, \(name)!")
}

let numberOfLegs = ["spider": 8, "ant": 6, "cat": 4]
for (animalName, legCount) in numberOfLegs {
    print("\(animalName)s have \(legCount) legs")
}


for i in 1...10{
    print(i)
}

//------------- underscore
for _ in 1...5{
    print(String(repeating: "rafa", count: 3))
}

print (Int.random(in: 1...10))


//------------- Optional

//var vitorias:Int?
//print (vitorias)

//var vitorias2:Int = vitorias
//print(vitorias2)

//deve ser evitado
//var vitorias2:Int! = vitorias
//print(vitorias2)


//var vitorias:Int? = 10
//var vitorias2:Int! = 5
//print(vitorias)
//print(vitorias2)


//if let vitorias3 = vitorias{
//    print("vc ganhou \(vitorias3)")
//}else{
//    print("sem campeao")
//}



//----------------- ARRAYS

//var jogadores: [String] = []
//var jogadores: [String]?
//type inference
var jogadores = ["Pele", "Messi", "Rapha", "CR7"]
jogadores.append("Neymar")
for j in jogadores{
    print(j)
}
for (index, value) in jogadores.enumerated() {
    print("Item \(index + 1): \(value)")
}
print(jogadores[0])
print(jogadores.count)
print(jogadores.isEmpty)
print(jogadores.sorted())


var n1 = Array(repeating: 2, count: 3)
var n2 = [3,4,5]

var n3 = n1+n2
print(n3)
//var n4 = n1*n2
//print(n4)


n3[1...4] = [10,11,12,13]
print(n3)

//não vai atualizar
n3.insert(90, at: n3.endIndex-1)
print(n3)
print(n3.filter({n in n > 10}))
//print(n3.filter({!0 > 10}))
print(n3.contains(2))

jogadores.forEach({j in print(j)})

print(n3.map({n in n*2}))
print(n3.map({n in n*2}).reduce(0, {total,n in total+n}))
print(n3)

// relembrando o unwrapped
//var numMax = n3.max()
//print(numMax + 10)

//----------------- TUples
var anyArray:[Any] = ["Festa", 10, true, 20.3]
anyArray.forEach({a in print(a)})

var anyTuples = ("Festa", 10, true, 30.3)
var (produto, quantidade, aconteceu, valor) = anyTuples
print(produto)
print(type(of: produto))
print(type(of: valor))


// namedTuples
var orcamento = (produto: "festa", quantidade: 10, aconteceu:true, valor:30.3)
print(orcamento.produto)
print(orcamento.1)

//------------------------ SET's

var orgaosExecutivo = Set<String>()
orgaosExecutivo.insert("cgu")
orgaosExecutivo.insert("agu")
orgaosExecutivo.insert("bacen")
orgaosExecutivo.insert("aneel")
orgaosExecutivo.insert("cgu")

print(orgaosExecutivo.count)
print(orgaosExecutivo.contains("tcu"))
print(orgaosExecutivo.contains("cgu"))

var orgaosLegislativo: Set<String> = ["Senado", "CLDF", "TCU", "TCDF", "Senado"]
print(orgaosLegislativo.count)


var orgaosUniao = orgaosExecutivo.union(orgaosLegislativo)
print(orgaosUniao)

var orgaosQueTrabalhei: Set<String> = ["bacen", "cgu"]
print(orgaosQueTrabalhei.isSubset(of: orgaosExecutivo))
print(orgaosQueTrabalhei.isDisjoint(with: orgaosLegislativo))

//--------------------- DICTIONARIES

var concursosInscrito: Dictionary<String,Int> = [:]
//var concursosInscrito: ["TCU":200, "SENADO": 500]
//var concursosInscrito: [String: Int] = [:]
concursosInscrito.updateValue(1000, forKey: "TCU")
concursosInscrito.updateValue(2000, forKey: "SENADO")
concursosInscrito.updateValue(300, forKey: "TCDF")
concursosInscrito["BACEN"] = 900

concursosInscrito.forEach({k,v in print("Concurso \(k) total \(v)")})

for concurso in concursosInscrito{
    print("Concurso \(concurso.key) - total \(concurso.value) ")
}


//procurando valores

var bacen = concursosInscrito["BACEN"]
print(bacen)
print(bacen!)


concursosInscrito.removeValue(forKey: "BACEN")
concursosInscrito.forEach({k,v in print("Concurso \(k) total \(v)")})
concursosInscrito.forEach({print("Concurso \($0) total \($1)")})


print(concursosInscrito.values)
print(concursosInscrito.keys)


print(concursosInscrito.filter({$0.key.contains("TC")}).keys)


//----------------- usando funções --------------------

func calcular(a:Int, b:Int) -> (multi: Int, soma: Int, subtracao:Int, divisao:Int){
    return (a*b, a+b, a-b, a/b)
}

let retorno = calcular(a:10, b:2)

print(retorno.multi)
print(retorno.soma)
print(retorno.subtracao)
print(retorno.divisao)

//--------------------- retorno opcional --------
//func pesquisarQuantidadeDeInscritos(nome:String = "STN") -> Int?{
func pesquisarQuantidadeDeInscritos(_ nome:String = "STN") -> Int?{
    
    if concursosInscrito.keys.contains(nome){
        return concursosInscrito[nome]
    }
    return nil
}

print(pesquisarQuantidadeDeInscritos("TCU"))
print(pesquisarQuantidadeDeInscritos("CD"))

//-----------------INOUT------------
func mudarValor(paramNome nome: inout String) -> String {
    nome = nome + "teste"
    return nome
}



var meuNome = "rafa"
mudarValor(paramNome: &meuNome)
print(meuNome)

//-----------------FUNCTION TYPES------------
var calc: (Int, Int) -> (multi: Int, soma: Int, subtracao:Int, divisao:Int) = calcular

print(calc(2,2))

var sayHello: (String) -> String = {"ola mundo \($0)"}
//var sayHello: (String) -> String = {return "ola mundo \($0)"}
//var sayHello: (String) -> String = {a in "ola mundo \(a)"}
print(sayHello("rafa"))


//------------------- CLOSURES

print(jogadores.sorted(by: {(s1:String, s2:String) -> Bool in return s1 > s2}))
print(jogadores.sorted(by: {(s1, s2) in return s1 > s2}))
print(jogadores.sorted(by: {(s1, s2) in s1 > s2}))
print(jogadores.sorted(by: {$0 > $1}))
print(jogadores.sorted(by: >))

//------------------- structure
struct Pessoa {
 
    var nome: String
    var anoNascimento: Int
    
    //computed property
    var idade: Int{
        2023 - self.anoNascimento
    }
//    func getIdade() -> Int{
//        return 2023 - self.anoNascimento
//    }
}

var p = Pessoa(nome:"rafa", anoNascimento: 1985)
//print(p.getIdade())
print(p.idade)
print(p.nome)

//------------------- class
class Animal {
    var nome: String
    
    init(_ nome: String) {
        self.nome = nome
    }
    deinit {
        print("free resource")
    }

    func falar() -> String{
        "miau \(self.nome)"
    }
}

var animal = Animal("node")
print(animal.falar())

//------------ manipulando referencias

var animal2 = animal
animal2.nome = "tunica"
print(animal.falar())

var p2 = p
p2.anoNascimento = 2022
//print(p.getIdade())
//print(p2.getIdade())

struct Tax {
  var amount: Int = 5
}
var tax1 = Tax()
var tax2 = tax1
tax1.amount = 20
print("\(tax1.amount), \(tax2.amount)")

class Product   {
  var price: Int = 5
}
var product1 = Product()
var product2 = product1
product1.price = 20
print("\(product1.price), \(product2.price)")


//------------ métodos mutaveis

struct Receita{
    var quantidadeBolos = 0
    
    mutating func plus(){
        self.quantidadeBolos += 1
    }
    mutating func minus(){
        self.quantidadeBolos -= 1
    }
}

var receita = Receita()
receita.plus()
receita.plus()
receita.plus()
print(receita.quantidadeBolos)


struct Employee {
  var salary: Double
  var tax = 0.2
  mutating func deductTax() {
    salary = salary - (tax * salary)
  }
}
var emp = Employee(salary: 100)
emp.deductTax()
print(emp.salary)







class Square {
  var width: Double = 0
  var area: Double {
    return width * width
  }
}

let square = Square()
square.width = 2
print(square.area)
