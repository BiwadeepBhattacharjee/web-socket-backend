#//step1.pull jdk image

#//Add:/copy jar file from target to docker file system
# Run the JarFile java

FROM openjdk:11

ADD ./target/Websocket-0.0.1-SNAPSHOT.jar /usr/src/Websocket-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "Websocket-0.0.1-SNAPSHOT.jar /"]