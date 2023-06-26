# Bloco Introdução

## Motivação e Por que programar?

Gostar de corrigir erros

## Olá Mundo

```javascript
alert('olá concurseiro')
```


# Bloco Fundamentos

## Conhecendo o Portugol

escreva('Qual é o seu nome?')
leia(nome)

escreva('qual é sua idade?')
leia(idade)

imprimir ('Seu nome é ', nome)
imprimir ('Sua idade é ', idade)


se idade maior do que 18 então
    escreva('vc é maior de idade')
senão
    escreva('vc é menor de idade')


## Conhecendo o JavaScript

```javascript
nome = prompt('Qual é seu nome?')
idade = prompt('Qual é sua idade?')

alert('Seu nome é '+ nome)
alert('Sua idade é '+ idade)

```


## Compilação x Execução

https://repl.it/languages/java10

https://repl.it/languages/nodejs


# Bloco lidando com o código

## Variáveis e tipos primitivos


```javascript
nome = 'Lorena'
idade = 30
nota = 9.76

typeof(nome)
typeof(idade)
typeof(nota)

nome2 = 'Matheus'
idade2 = 20
nota2 = 8.32

```



* guardar o nome de outro aluno na mesma variável para verificar que vai apagar a anterior


## Operadores e Precedência

* Qual a média de idade da sala?
    * falar sobre a precedência de operadores



```javascript
mediaIdade = idade + idade2 / 2
mediaIdade = (idade + idade2) / 2
```


* quem teve a maior nota?

```javascript
maiorNota = nota > nota2
typeof(maiorNota)
```



# Bloco Lógica de Programação

## Estruturas Condicionais & || !

## Estruturas de Repetição




# Bloco Funções

* função para imprimir nomes
* Função para calcular a idade
* Função para saber que passou no concurso
* função para calcular média de notas do concurso

## Valor e Referência

```javascript
var name = "Carlos"; var firstName = name;

name = "Carla";

console.log(name); // "Carla"
console.log(firstName); // "Carlos"



var myName = { firstName: "Carlos" }; var identity = myName;

myName.firstName = "Carla";

console.log(myName.firstName); // "Carla"
console.log(identity.firstName); // "Carla"

```


## Recursividade

```javascript


function latir(quantidade){

  if(quantidade == 0){
    return '';
  }

  return 'latir-'+ latir(quantidade-1);

}

console.log(latir(5))

```


# Bloco Strings

* Strings são imutáveis
* Igualdade das Strings


```javascript

let nome = 'rafa'

nome.toUpperCase()

var sobrenome = 'lacerda'

var nomeCompleto = 'raphael henrique lacerda pinho'

var descricao = 'meu nome é '+ nomeCompleto + 'possuo o passaporte numero 43212'

var email = 'lacerdaph@gmail.com'

let nome2 = 'rafa'

console.log(nome == nome2)

//chartAt
console.log(nome.charAt(2))


//concat
console.log(nome + sobrenome)
console.log(nome.concat(' ').concat(sobrenome))
console.log(nome)

//indexOf
console.log(nome.indexOf('silveira'))
console.log(nomeCompleto.indexOf('henrique'))


//match
var regexEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
console.log(email.match(regexEmail))


//search
var regexInteiros = /[0-9]/;  
console.log(descricao.search(regexInteiros))


//substring
console.log(descricao.substring(descricao.search(regexInteiros)))

//slice
console.log(nomeCompleto.slice(0, 5))

//split
console.log(nomeCompleto.split(' '))
````



# Bloco estrutura de Dados

* Criar alunos
* Adicionar na Lista
* Fazer uma lista de Aprovados
* Fazer uma lista de reprovados
* Descobrir a media