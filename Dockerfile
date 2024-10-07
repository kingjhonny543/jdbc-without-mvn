# Use the official OpenJDK 21 image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR files to the container
COPY lib/mysql-connector-j-9.0.0.jar /app/
COPY Java-Jdbc.jar /app/

# Command to run the application
CMD ["java", "-cp", "mysql-connector-j-9.0.0.jar;Java-Jdbc.jar", "Main"]
