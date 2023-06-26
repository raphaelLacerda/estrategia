class IndexController {
    constructor() {
        this._alunos = [];
    }

    calcularTotalGasto(){
        console.log('início do cálculo');

        let promessa = this._alunos[0].calcularTotalGasto();
        
        promessa.then(resultado => {
                console.log('retorno do cálculo '+ resultado)
            })
            .catch(erro => {
                console.log(erro);
            });
        console.log('segue o programa');
        
    }

    novoAluno() {
        let id = this._alunos.length + 1;
        let aluno = new Aluno(id, 'Rafa' + id, Math.floor(Math.random() * 10));
        aluno.devedor = true;
        this._alunos.push(aluno);

        console.log('Aluno adicionado ' + aluno);
    }

    mostrarAlunos() {
        document.getElementById('main').innerHTML = this._alunos;
    }

    mostrarAlunosAcimaDaMedia() {

        let alunosAcimaDaMedia = this._alunos.filter(a => a.nota >=5);
        document.getElementById('main').innerHTML = alunosAcimaDaMedia;
    }
}
indexController = new IndexController();
