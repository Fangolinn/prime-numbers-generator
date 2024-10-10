FROM amazoncorretto:11 AS build
COPY ./gradle/ ./gradle/
COPY gradlew settings.gradle ./
COPY ./app/build.gradle ./app/
RUN ./gradlew check
COPY ./app ./app
RUN ./gradlew build

FROM amazoncorretto:11 AS runtime
COPY --from=build /app/build/libs/*-boot.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "./app.jar"]
