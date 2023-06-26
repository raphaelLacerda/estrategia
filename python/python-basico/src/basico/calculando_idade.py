import datetime

def calcular_idade(nascimento) -> int:
    return datetime.date.today().year - nascimento

if __name__ == '__main__':
    print(calcular_idade(1985))