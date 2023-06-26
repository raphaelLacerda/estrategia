import { Aluno } from "./aluno";
import { Curso } from "./curso";

var bb = new Curso("BB", 10);
var string = new Curso("BRB", 5);

var rafa = new Aluno("rafa");
var maria = new Aluno("maria");

rafa.contratar(bb)
rafa.contratar(string)
maria.contratar(bb);

// console.log(rafa.getTotalDeCursos())
// console.log(maria.getTotalDeCursos())

rafa.historico();


var todosAlunos: [number, Aluno][];
todosAlunos = [ [1,rafa], [2,maria]]

console.log(todosAlunos)
// console.log(todosAlunos[1])
// console.log(todosAlunos[2])