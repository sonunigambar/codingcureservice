FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} Coding_cure-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Coding_cure-0.0.1-SNAPSHOT.jar"]
EXPOSE 9090
