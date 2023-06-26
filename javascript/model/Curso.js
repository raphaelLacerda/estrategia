class Curso{
    constructor(nome, preco){
        this._nome = nome;
        this._preco = preco;
    }

    get preco(){
        return this._preco;
    }
}