import { Curso } from "./curso";
import { Validator } from "./validator";

export class Aluno {
    nome: string;
    cursos: Curso[] = [];
  
    constructor(nome: string) {
      if(Validator.validarNome(nome)){
        this.nome = nome;
      }
    }
  
    contratar = (curso: Curso) => this.cursos.push(curso)
  
    historico():void{
  
      for(var c in this.cursos){
          console.log(this.cursos[c]);
      }
    }
  
    getTotalDeCursos(): number{
        return this.cursos.length;
    }
  }
  