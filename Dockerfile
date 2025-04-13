FROM eclipse-temurin:21

# Install Maven inside the container
RUN apt-get update && apt-get install -y maven

WORKDIR /app

# Copy only pom.xml first to leverage Docker cache
COPY pom*.xml ./

# Install dependencies (this step will be cached unless pom.xml changes)
RUN mvn clean install

# Copy the rest of the project source code into the container
COPY . .

# Expose the port the app runs on
EXPOSE 8080

# Use the Spring Boot DevTools and run the application with hot reload
CMD ["mvn", "spring-boot:run"]