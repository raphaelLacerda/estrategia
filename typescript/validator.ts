import { Curso } from './curso';
export namespace Validator {
  export function validarNome(nome: string) {
    return nome.length >= 3;
  }

  export function validarCursos(cursos: Curso[]) {
    return cursos.length >= 3;
  }
}
