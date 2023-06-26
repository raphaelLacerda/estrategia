import os
if __name__ == '__main__':
    # os.remove('concursos.txt')

    if os.path.exists("concursos.txt"):
        os.remove("concursos.txt")
    else:
        print("arquivo nao existe")