# FROM eclipse-temurin:17-jdk-alpine
# ARG JAR_FILE
# COPY ${JAR_FILE} Coding_cure-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","/Coding_cure-0.0.1-SNAPSHOT.jar"]
# EXPOSE 9090


# Use an official OpenJDK runtime as the base image
FROM adoptopenjdk:11-jre-hotspot

# Set environment variables for the Spring Boot application
ENV JAVA_OPTS="-Xmx512m"

# Create a directory for the application
WORKDIR /app

# Copy the Spring Boot executable JAR into the container
COPY target/coding-cure.jar coding-cure.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8080

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "coding-cure.jar"]

