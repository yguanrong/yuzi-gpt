FROM maven:3.8.1-jdk-8-slim as builder

MAINTAINER yupi

# Copy local code to the container image.
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# 声明环境变量，这样容器就可以在运行时访问它们
ENV OPENAI_MODEL=text-davinci-003
ENV OPENAI_API_KEY=你的API_KEY

# Run the web service on container startup.
ENTRYPOINT ["java","-jar","/app/target/yuzi-gpt-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]