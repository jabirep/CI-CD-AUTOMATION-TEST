# Use a base image with JDK installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from your local machine into the container
COPY target/HRMS-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Run the executable JAR file
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
