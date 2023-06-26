"use strict";
exports.__esModule = true;
exports.Aluno = void 0;
var validator_1 = require("./validator");
var Aluno = /** @class */ (function () {
    function Aluno(nome) {
        var _this = this;
        this.cursos = [];
        this.contratar = function (curso) { return _this.cursos.push(curso); };
        if (validator_1.Validator.validarNome(nome)) {
            this.nome = nome;
        }
    }
    Aluno.prototype.historico = function () {
        for (var c in this.cursos) {
            console.log(this.cursos[c]);
        }
    };
    Aluno.prototype.getTotalDeCursos = function () {
        return this.cursos.length;
    };
    return Aluno;
}());
exports.Aluno = Aluno;
//# sourceMappingURL=aluno.js.map