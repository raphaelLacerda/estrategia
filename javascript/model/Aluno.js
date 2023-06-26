class Aluno {
    //https://stackoverflow.com/questions/22156326/private-properties-in-javascript-es6-classes
    constructor(id, nome, nota) {
        this._id = id;
        this._nome = nome;
        this._nota = nota;
        this._nivelConhecimento = 0;
        this._cursos = [];
    }

    contrata(curso) {
        this._cursos.push(curso);
    }

    passouDeAno() {
        return this._nota >= 5;
    }

    estuda() {
        this._nivelConhecimento++;
    }

    //http://es6-features.org/#GetterSetter
    get nota() {
        return this._nota;
    }

    get nivelConhecimento() {
        return this._nivelConhecimento;
    }

    calcularTotalGasto() {
        // return this._cursos.map(c => c.preco).reduce((a, b) => a + b);
        let p = new Promise((resolve, reject) => {

            console.log('calculando algo super complexo e demorado')
            setTimeout(()=>{
                reject('erro');
            }, 5000);
        })
        return p;  
    
        
    }

    toString() {
        return 'Aluno ' + this._id + ' - nome: ' + this._nome + ' - nota: ' + this._nota + '</br>';
    }
}
