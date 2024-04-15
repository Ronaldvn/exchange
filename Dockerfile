FROM openjdk:17-oracle
COPY  build/libs/*.jar exchange-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "exchange-0.0.1-SNAPSHOT.jar"]