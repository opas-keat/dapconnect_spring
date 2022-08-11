# FROM adoptopenjdk/openjdk11-openj9
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# RUN addgroup -S springboot && adduser -S sbuser -G springboot
# USER sbuser
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","/app.jar"]
#
# FROM adoptopenjdk/openjdk11-openj9 as build
# WORKDIR /workspace/app
#
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# COPY src src
#
# RUN ./mvnw install -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
# FROM adoptopenjdk/openjdk11-openj9
# VOLUME /tmp
# ARG DEPENDENCY=/workspace/app/target/dependency
# COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
# COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]
# FROM maslick/minimalka:jdk11
# FROM --platform=linux/amd64 eclipse-temurin:11.0.16_8-jre-alpine
FROM adoptopenjdk:11.0.11_9-jre-hotspot-focal
# Refer to Maven build -> finalName
ARG JAR_FILE=target/springBootApp.jar
# cd /app
WORKDIR /app
# EXPOSE 8080
# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} ./app.jar
# java -jar /opt/app/app.jar
CMD java $JAVA_OPTIONS -jar app.jar