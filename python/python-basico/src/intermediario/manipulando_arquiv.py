if __name__ == '__main__':
    print('ola')
    arquivo_concursos = open('concursos.txt', 'r')
    # print(arquivo_concursos)
    # print(arquivo_concursos.read())
    print('segunda leitura')
    arquivo_concursos.seek(0)
    # print(arquivo_concursos.read(1))
    # print(arquivo_concursos.readline())
    print(arquivo_concursos.readlines()[1:])

    # for c in arquivo_concursos:
    #     print(c)

    # arquivo_concursos.write('ola mundo \n')
    arquivo_concursos.close()

    # print('novo arquivo')
    # with open('concursos.txt', 'r') as arquivo_concursos_2:
    #     for c2 in arquivo_concursos_2:
    #         print(c2)
    #
    # data = ["\ntest 1 \n", "test 2 \n", "test 3 \n"]
    # with open('concursos.txt', 'a') as f:
    #     f.writelines(data)
