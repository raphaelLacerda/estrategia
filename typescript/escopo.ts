var a: number = 10;

class Escopo{
    a:number = 100;
    static _a: number = 150;

    imprimir(): void{
        var a = 200;

        console.log(a);
        console.log(this.a);
        console.log(Escopo._a);
    }
}

new Escopo().imprimir();
console.log(a);