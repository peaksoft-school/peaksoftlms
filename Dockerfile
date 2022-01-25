FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD target/peaksoftlms.jar peaksoftlms.jar
ENTRYPOINT ["java","-jar","peaksoftlms.jar"]