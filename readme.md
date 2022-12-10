openssl genrsa -out keypair.pem 2048

openssl rsa -in keypair.pem -pubout -out public.pem

openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem



```dockerfile
FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/nikixp/jwt.git

FROM maven:3.8.6-eclipse-temurin-19-alpine AS build
WORKDIR /app
COPY --from=0 /app/jwt /app/jwt
#COPY src /home/spring-demo/src
#COPY pom.xml /home/spring-demo
#COPY settings.xml /root/.m2
RUN mvn -f /app/jwt/pom.xml clean install

FROM openjdk:19
COPY --from=build /app/jwt/target/jwt.jar /app/jwt/jwt.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/jwt/jwt.jar", "spring.profiles.active=dev"]
```

