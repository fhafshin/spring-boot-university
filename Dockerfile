FROM openjdk:23
EXPOSE 8080
ADD target/spring-boot-academy.jar spring-boot-academy.jar

ENTRYPOINT ["java","-jar","/spring-boot-academy.jar"]