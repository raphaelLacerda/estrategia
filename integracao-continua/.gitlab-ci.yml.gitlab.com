image: maven:3.6.2-jdk-12
services:
- docker:dind

build:
  stage: build
  script:
  - mvn clean install
