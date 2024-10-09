FROM amazoncorretto:11 AS build
COPY . .
RUN ./gradlew build

FROM amazoncorretto:11 AS runtime
COPY --from=build /app/build/libs/app.jar .
EXPOSE 8080
CMD ["java", "-jar", "./app.jar"]
