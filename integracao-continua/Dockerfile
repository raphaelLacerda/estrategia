FROM maven:3.6.3-jdk-13 as builder
WORKDIR /app
COPY . /app
RUN mvn clean install

FROM openjdk:13.0.2-buster
WORKDIR /app
COPY --from=builder /app/target/coruja*.jar /app/coruja.jar

RUN ls

ENTRYPOINT ["java","-jar","corjar.jar"]
