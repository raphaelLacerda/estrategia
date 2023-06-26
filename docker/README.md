# Aula Docker

## Figuras para a aula

![alt Figura 1](imgs/docker.png)
https://d2iq.com/blog/docker-vs-kubernetes-vs-apache-mesos


![alt Figura 2](https://docs.docker.com/images/Container%402x.png)

![alt Figura 3](https://docs.docker.com/images/VM%402x.png)










## Nginx

* docker run nginx:alpine
* -d
* docker logs -f
* --rm
* -it
* exec

* /etc/nginx/conf
  
* alterar pagina inicial
* remvover container
* iniciar novo container
* alterar pagina inicial
* parar container
* start containe
* criando uma nova imagem com nosso index - docker commit


> Fazer revisão até slide 46


## criando nova imagem nginx com vim e index alterado

* passando index por copy
  * /usr/share/nginx/html/index.html
* Depois fazer com mapeamento de volume passando o index lá pra dentro


## Hello world

* https://hub.docker.com/_/hello-world

* docker run alpine:latest "echo" "Hello, World"

## Java

* Hello World Java

* criando nossa imagem java com alpine

* alterando nosso hello world java para nossa imagem


## Node
* npm install --sever


## Comandos Básicos

* docker info
* docker ps
* docker ps -a
* docker images ls
* docker build . -t 
* docker run
* docker pull
  * ports
  * volumes
  * daemon

* docker stop
* docker start
    * explicar o stateless aqui
* docker network create
dsdsdsd

## Docker-compose














