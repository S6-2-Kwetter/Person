FROM azul/zulu-openjdk-alpine:17
EXPOSE 8081
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} person-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/person-0.0.1-SNAPSHOT.jar"]
