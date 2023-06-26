"use strict";
exports.__esModule = true;
var aluno_1 = require("./aluno");
var curso_1 = require("./curso");
var bb = new curso_1.Curso("BB", 10);
var string = new curso_1.Curso("BRB", 5);
var rafa = new aluno_1.Aluno("rafa");
var maria = new aluno_1.Aluno("maria");
rafa.contratar(bb);
rafa.contratar(string);
maria.contratar(bb);
// console.log(rafa.getTotalDeCursos())
// console.log(maria.getTotalDeCursos())
rafa.historico();
var todosAlunos;
todosAlunos = [[1, rafa], [2, maria]];
console.log(todosAlunos);
// console.log(todosAlunos[1])
// console.log(todosAlunos[2])
//# sourceMappingURL=estrategia.js.map