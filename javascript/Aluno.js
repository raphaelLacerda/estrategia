class Aluno{

    constructor(id, nome, email, nota){
        this._id = id;
        this._nome = nome;
        this._email = email;
        this._nota = nota;
        this._cursos = [];
    }

    get id(){
        return this._id;
    }
    get nome(){
        return this._nome;
    }
    set nome(nomeNovo){
        this._nome = nomeNovo;
    }
    get email(){
        return this._email;
    }
    get nota(){
        return this._nota;
    }

    get cursos(){
        return this._cursos;
    }

    contratar(curso){
        this._cursos.push(curso);
    }
    estudar(){
        this.nivelDeConhecimento++;
    }

    get totalGasto(){
        return this._cursos.map(c => c.preco).reduce((a,b) => a+b);
    }

    toString(){
        return 'ID: '+ this._id+ ' Nome: '+ this._nome + ' - Cursos: '+ this._cursos+ '<br/>';
    }

}