# Cobol

Documentação utilizada
https://medium.com/@yvanscher/7-cobol-examples-with-explanations-ae1784b4d576


## Construindo a imagem

* Buildando a imagem

```
docker build . -t cobol
```

* Rodando a imagem

```
docker run -it  -v $(pwd):/app cobol /bin/bash
```

## Executando programa

* compilação

```
cobc -x -o hello hello.cbl
```

* execução

```
./hello
```
