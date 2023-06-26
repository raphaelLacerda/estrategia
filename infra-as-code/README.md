# Infra as Code

## terraform

docker pull terraformdocker/terraform


## ansible

docker run --rm -v $(pwd):/ansible/playbooks -it mullnerz/ansible-playbook bash

https://raw.githubusercontent.com/ansible/ansible/devel/examples/ansible.cfg

docker network create --driver bridge rafa-net
docker run --rm -v $(pwd):/ansible/playbooks --network=rafa-net -it ansible-local:1 bash
docker run --rm -it --network=rafa-net --network-alias=nginx iliyan/docker-nginx-sshd bash
service ssh start



ssh root@nginx
ansible -m ping 'test-servers' -vvv
ansible-playbook /ansible/playbooks/ansible.yaml


* https://galaxy.ansible.com/search?deprecated=false&keywords=&order_by=-relevance