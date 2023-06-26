FROM jenkinsci/blueocean

USER root

RUN apk --no-cache add shadow
RUN usermod -aG docker jenkins
RUN usermod -aG docker root