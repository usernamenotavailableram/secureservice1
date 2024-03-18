# Use a base image with JDK 21 installed
FROM adoptopenjdk/openjdk21:alpine-jre AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the compiled application JAR file to the container
COPY target/*.jar secure-service-0.0.1-SNAPSHOT.jar

# Expose the port on which the Spring Boot application will run (if applicable)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", " secure-service-0.0.1-SNAPSHOT.jar"]
