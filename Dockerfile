FROM openjdk:8
ADD target/employee-service-0.1.jar employee.jar
ENTRYPOINT ["Java", "-jar", "/employee.jar"]