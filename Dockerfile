#FROM harbor.lan.ctirobot.com/dockerhub/maven:3.8.6-jdk-8 as builder
#RUN mvn clean package

FROM harbor.lan.ctirobot.com/dockerhub/openjdk:openjdk8-jre-tini
WORKDIR /opt

ENV JAVA_OPTS="-Xms64M -Xmx256M -Duser.timezone=Asia/Shanghai"
# ENV SPRING_OPTS="--spring.profiles.active=development"
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' > /etc/timezone
# COPY --FROM target/springboot-multi-datasource.jar /opt/app.jar
COPY target/springboot-multi-datasource.jar /opt/app.jar
# COPY entrypoint.sh /opt/entrypoint.sh
# RUN chmod +x /opt/entrypoint.sh

EXPOSE 8080
CMD ["java",  "-jar", "/opt/app.jar"]
