# Use a base image with JDK 21 installed
FROM openjdk:18.0-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled application JAR file to the container
COPY target/*.jar secure-service-0.0.1-SNAPSHOT.jar

# Expose the port on which the Spring Boot application will run (if applicable)
EXPOSE 8083

# Command to run the Spring Boot application
CMD ["java", "-jar", " secure-service-0.0.1-SNAPSHOT.jar"]
