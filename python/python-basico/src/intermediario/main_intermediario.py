from src.intermediario.aluno import Aluno
from src.intermediario.concurso import Concurso

if __name__ == '__main__':
    a = Aluno("rafa", "rafa@gmail.com", 1988)
    print(a)
    print(a.email)
    print(a.nome)

    b = Aluno("matheus", "matheys@gmail.com", 2000)
    print(b)
    print(b.nome)
    print(b.email)
    b.imprimir()

    b.nome = "matheus alterado"
    b.imprimir()

    # del b.nome
    #
    # b.imprimir()

    print(b.get_idade())
    print(a.get_idade())

    c = Aluno("paula", "paula@gmail.com", 1970)

    print(a > b)
    print(b > a)
    print(b > c)
    print(c > b)

    alunos = [a, b, c]

    print(alunos)
    alunos.sort()
    print(alunos)
    alunos.sort(reverse=True)
    print(alunos)
    alunos.sort(key=lambda e: e.nome)
    print(alunos)

    print(a in alunos)
    print(b in alunos)
    print(c in alunos)

    d = Aluno("paula", "paula@gmail.com", 1971)

    concursos = Concurso(alunos)

    print(d in concursos)
    print("paula" in concursos)

    novo_aluno = Aluno("node", "node@gmail.com", 2010)

    print(novo_aluno in concursos)
    concursos + novo_aluno
    concursos + novo_aluno
    concursos + novo_aluno
    concursos + novo_aluno
    print(novo_aluno in concursos)

    print(concursos)

    print(f"Total de alunos criados {Aluno.total}")

    print(dir(a))

    a.novo_atributo = "finalmente"

    print(a.novo_atributo)

    print(a._Aluno__nome)
