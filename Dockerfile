FROM openjdk:8
MAINTAINER zomeli.villanueva.com
COPY target/DESAFIO_BCP-0.0.1.jar docker-desafio-bcp-0.0.1.jar
ENTRYPOINT ["java","-jar","/docker-desafio-bcp-0.0.1.jar"]