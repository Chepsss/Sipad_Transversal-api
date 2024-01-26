FROM openjdk:11
COPY /ms-sipad-api-rest/target/ms-sipad-rest-0.0.1.jar /usr/local/lib/ms-sipad-api.jar

EXPOSE 8089

ENTRYPOINT ["java","-jar","/usr/local/lib/ms-sipad-api.jar"]