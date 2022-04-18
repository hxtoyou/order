FROM java:8
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 1110
ENTRYPOINT ["java","-jar","/app.jar"]