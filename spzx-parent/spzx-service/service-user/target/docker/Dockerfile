FROM centos7-jdk17
MAINTAINER atguigu
EXPOSE 8512
ADD target/service-user-1.0-SNAPSHOT.jar /service-user-1.0-SNAPSHOT.jar

WORKDIR /
ENTRYPOINT ["java" , "-jar" , "service-user-1.0-SNAPSHOT.jar"]