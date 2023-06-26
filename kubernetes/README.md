# Aula Kubernetes

Colocando o K8s para funcionar no mac

* https://matthewpalmer.net/kubernetes-app-developer/articles/how-to-run-local-kubernetes-docker-for-mac.html


![](img/ingress.svg)

Documentação base para o curso

* https://kubernetes.io/docs/home/

### Dashboard

* https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
* https://github.com/kubernetes/dashboard

Acessando interface

* kubectl proxy
* http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/.



Comando para criação de usuário e geração de token

* kubectl apply -f dashboard-adminuser.yaml
* kubectl apply -f roles.yaml
* kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')


## Mostrar os Controllers em acao

* CronJob
* Deployment
  * Somente deployar o nginx
* Replica

## Entendendo os Services

* deployar o nginx do Service e explicar os tipos de ServiceType


## Criando Hello World

Primeiro, vamos subir um servidor de registry

* docker run -p 5000:5000 registry
* http://localhost:5000/v2/_catalog
* http://localhost:5000/v2/hello-node/tags/list

## Deployando replicas de um frontend

kubectl apply -f https://kubernetes.io/examples/controllers/frontend.yaml

## Criando uma applicação Web


* Criar a aplicacao hello node
* criar o deployment
* criar o service com loadbalancer e nodeport
* atualizar hello node - nova image com nova tag
* fazer o update no deployment
* vai dar pau pq nao fiz o push da imagem para o repo local
* mostrar q a aplicacao continua funcionando
* faz o push da imagem
* mostrar os containers antigos morrendo aos poucos


> para testar o load balancer precisa fazer varias requisicoes, depois para um tempo e voltar a fazer

## Deployando no ArgoCD

```
kubectl apply -n argocd -f app.yaml
```

Exemplos em: https://github.com/argoproj/argocd-example-apps


* Onde fica o arquivo app.yaml para configuração do ARGO?

Este arquivo deve ficar no repositório dos helmcharts

Exemplo: 
https://argo-cd.readthedocs.io/en/stable/operator-manual/cluster-bootstrapping/


* Sugestão de workflow de CI

https://argo-cd.readthedocs.io/en/stable/user-guide/ci_automation/

* badges

https://github.com/argoproj/argo-cd/blob/master/docs/operator-manual/argocd-cm.yaml#L14


# Swarm

Referência base: https://blog.geekhunter.com.br/orquestracao-de-conteineres-docker-swarm-portainer/

## Inicialização



* iniciando o swarm
docker swarm init

* portainer

docker volume create portainer_data

docker run -d -p 8000:8000 -p 9000:9000 --name=portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer