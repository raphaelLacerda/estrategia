# AIC


* usar o gitlab para buildar o projeto
* falar do sonar scanner

## Jenkis

* pegar o password no startup
* 1ca1b56c87f4412bb57e6bd03c01481b

## GITLAB
* root / 12345678
* criar projeto coruja bank
* http://localhost/gitlab/admin/runners
* habilitar registry em /etc/gitlab.rb
  * procurar por gitlab_rails['gitlab_default_projects_features_container_registry']
  * procurar por registry['enable'] = true
  * gitlab-ctl reconfigure
  * gitlab-ctl restart
## Runner

* entrar no container do runner
* gitlab-runner register
* http://172.17.0.1/gitlab/
* pegar o token do gitlab
* atualizar gitlab: http://localhost/gitlab/admin/runners


* fazer push do coruja bank
* copiar o Dockerfile, sonar e o .gitlab-ci


## jenkins
* open blue ocean
* create pipeline
* http://172.17.0.1/gitlab/root/corujabank.git
* root / 12345678

> https://medium.com/swlh/getting-permission-denied-error-when-pulling-a-docker-image-in-jenkins-docker-container-on-mac-b335af02ebca



## Nexus

* criar repositorio maven hosted
* criar maven-local
mvn deploy:deploy-file -Durl=http://localhost:8082/repository/maven-local/ -DgroupId=br.com.estrategia -DartifactId=corujabank -Dversion=1.0.0 -Dpackaging=jar -DskipTests -Dmaven.install.skip=true -DrepositoryId=maven.nexus -Dfile=corujabank-0.0.1-SNAPSHOT.jar

## Comandos úteis
* docker volume ls
* docker volume inspect integracao-continua_gitlab-data-config
