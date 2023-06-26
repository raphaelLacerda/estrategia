import datetime


class Aluno:
    total = 0

    def __init__(self, nome, email, data_nascimento):
        self.nome = nome
        self.email = email
        self.ano_nascimento = data_nascimento
        Aluno.incrementar()

    @classmethod
    def incrementar(cls):
        cls.total += 1

    # def __str__(self):
    #     return f"Sou o aluno {self.nome} com o email {self.email}"

    def __repr__(self):
        return f"Sou o aluno {self.nome} com o email {self.email} com idade {self.get_idade()}"

    def imprimir(self):
        print(f"Sou o aluno {self.nome} com o email {self.email}")

    def get_idade(self):
        return datetime.date.today().year - self.ano_nascimento

    def __gt__(self, other):
        return self.get_idade() > other.get_idade()

    def __eq__(self, other):
        print("checking contains EQ")
        return self.nome == other.nome

    def __setattr__(self, name, value):
        print(f"settando atributo {name} com valor {value} ")
        super().__setattr__(name, value)

    def __getattr__(self, item):
        print(f"buscando atributo {item} ")
        super().__getattr__(item)

    def __contains__(self, item):
        print("checking contains CT")
        return item.nome == self.nome

    @property
    def nome(self):
        return self.__nome

    @nome.setter
    def nome(self, nome):
        if len(nome) > 3: self.__nome = nome
