# Use a base image with Java installed
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Java files and the MySQL connector JAR into the container
COPY out/ ./
COPY lib/mysql-connector-j-9.0.0.jar ./lib/

# Specify the command to run your Java application
CMD ["java", "-cp", ".;lib/mysql-connector-j-9.0.0.jar", "Main"]
