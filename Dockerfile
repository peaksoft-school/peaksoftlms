FROM adoptopenjdk/openjdk11
RUN mvn clean package install
EXPOSE 8080
ADD target/peaksoftlms.jar peaksoftlms.jar
ENTRYPOINT ["java","-jar","peaksoftlms.jar"]