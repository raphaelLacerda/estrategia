class Concurso:

    def __init__(self, alunos):
        self.aprovados = alunos

    def __add__(self, other):
        if other not in self.aprovados: self.aprovados.append(other)

    def __contains__(self, item):
        if (hasattr(item, 'nome')):
            return item in self.aprovados
        else:
            return item in list(map(lambda x: x.nome, self.aprovados))

    def __repr__(self):
        return f'aprovados {self.aprovados}'
