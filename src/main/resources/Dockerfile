FROM openjdk:8

# Set the working directory inside the container.
WORKDIR /app

# Copy the Spring Boot JAR file into the container.
COPY ../../../target/CrudOperations-0.0.1-SNAPSHOT.jar app.jar

# Copy the configuration file into the container.
#COPY src/main/resources/application.properties src/main/resources/application.properties

# Expose the port that your Spring Boot application is listening on.
EXPOSE 8080

# Set the command to run the application when the container starts.
ENTRYPOINT ["java", "-jar", "app.jar"]
