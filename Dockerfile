FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sepomex.jar
ENTRYPOINT ["java","-jar","/sepomex.jar"]