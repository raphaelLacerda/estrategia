FROM ubuntu
RUN apt-get update && apt-get install -y openssh-server && apt-get install -y vim

COPY ssh_config /etc/ssh/ssh_config
CMD service ssh start