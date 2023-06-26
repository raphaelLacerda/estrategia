class Curso{

    constructor(nome, preco){
        this._nome = nome;
        this._preco = preco;
    }

    get nome(){
        return this._nome;
    }

    get preco(){
        return this._preco;
    }

    toString(){
        return this._nome + ' - R$'+ this._preco;
    }
}