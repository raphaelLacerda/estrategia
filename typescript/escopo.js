var a = 10;
var Escopo = /** @class */ (function () {
    function Escopo() {
        this.a = 100;
    }
    Escopo.prototype.imprimir = function () {
        var a = 200;
        console.log(a);
        console.log(this.a);
        console.log(Escopo._a);
    };
    Escopo._a = 150;
    return Escopo;
}());
new Escopo().imprimir();
console.log(a);
//# sourceMappingURL=escopo.js.map