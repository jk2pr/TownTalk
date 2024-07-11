# Use AdoptOpenJDK OpenJDK 11 base image
# Stage 1: Build the application
FROM adoptopenjdk:11-jdk-hotspot AS build

# Install necessary tools (Git and Gradle in this example)
RUN apt-get update && \
    apt-get install -y git && \
    apt-get install -y unzip && \
    apt-get install -y curl && \
    apt-get clean;

# Set the working directory inside the container
WORKDIR /app

# Clone your Spring Boot application repository (replace with your repository URL)
RUN git clone https://github.com/jk2pr/TownTalk.git .

# Build your Spring Boot application
RUN ./gradlew clean build

# Stage 2: Create the final Docker image for runtime
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file from the build stage into the container
COPY --from=build /app/build/libs/*.jar app.jar

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]
