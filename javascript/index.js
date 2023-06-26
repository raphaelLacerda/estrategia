class IndexController{
 
    constructor(){
        this.alunos = [];
    }

    adicionarAluno(){
        let idAluno = this.alunos.length + 1;
        let aluno = new Aluno(idAluno, 'Rafa'+idAluno, Math.floor(Math.random() * 1000)+'@gmail.com', Math.floor(Math.random() * 10));
        let curso = new Curso('Curso'+Math.floor(Math.random() * 10), Math.floor(Math.random() * 100));
        
        aluno.contratar(curso);

        console.log(aluno);
        aluno.nivelDeConhecimento = 0;
        this.alunos.push(aluno);
    }

    fazerAlunoEstudar(idAluno){

        let aluno = this.alunos[idAluno];
        aluno.estudar();
    }

    mostrarTodos(){

        this._imprimirAlunos(this.alunos);
    }

    mostrarAlunosAcimaDaMedia(){

        let alunosAcimaDaMedia = this.alunos.filter( a => a.nota >= 7);

        this._imprimirAlunos(alunosAcimaDaMedia);
    }

    _imprimirAlunos(alunos){
        document.getElementById('main').innerHTML = alunos;
    }
}

var indexController = new IndexController();