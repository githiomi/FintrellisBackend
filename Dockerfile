FROM openjdk:22-ea-1
LABEL authors="dangit"

# Set the working directory
WORKDIR /app

# Set ENV variables
ENV USERNAME="admin"
ENV PASSWORD="admin123"

# Copy JAR File
COPY /target/InkVibe-0.0.1-SNAPSHOT.jar /app/InkVibe.jar

# Port
EXPOSE 8080

ENTRYPOINT ["java", "-jar",  "InkVibe.jar"]

# Docker Build
#docker build -t inkvibe:1.0 .

# Docker Build Hub
# docker build -t githiomi/inkvibe:1.0 .

# Run Docker
#docker run -p 8080:9000 inkvibe:latest
#docker run -d -p 8080:9000 -e USERNAME=admin -e PASSWORD=admin123 --name inkvibe

