FROM eclipse-temurin:21

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom*.xml ./


RUN mvn clean install

COPY . .


EXPOSE 8080

CMD ["mvn", "spring-boot:run"]