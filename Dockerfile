FROM amazoncorretto:17-alpine-jdk
WORKDIR /app

COPY ./target/demo-test-repository-1.jar demo-test-repository.jar

ENTRYPOINT ["java","-jar","demo-test-repository.jar"]