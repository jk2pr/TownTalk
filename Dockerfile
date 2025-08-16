FROM openjdk:21
EXPOSE 8080
ADD target/TownTalk.jar TownTalk.jar
ENTRYPOINT ["java","-jar","/towntalk.jar"]