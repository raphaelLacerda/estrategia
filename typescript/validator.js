"use strict";
exports.__esModule = true;
exports.Validator = void 0;
var Validator;
(function (Validator) {
    function validarNome(nome) {
        return nome.length >= 3;
    }
    Validator.validarNome = validarNome;
    function validarCursos(cursos) {
        return cursos.length >= 3;
    }
    Validator.validarCursos = validarCursos;
})(Validator = exports.Validator || (exports.Validator = {}));
//# sourceMappingURL=validator.js.map