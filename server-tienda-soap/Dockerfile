FROM openjdk:11-jdk-slim
COPY "/target/tienda-server-soap.jar" "tienda-server-soap.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tienda-server-soap.jar"]