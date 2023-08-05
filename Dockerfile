FROM openjdk:8
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
