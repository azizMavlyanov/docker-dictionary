FROM openjdk:11
COPY build/libs/dictionary.jar dictionary.jar
CMD ["java", "-jar", "dictionary.jar"]
EXPOSE 8085