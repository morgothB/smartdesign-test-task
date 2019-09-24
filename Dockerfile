FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /restservice/lib
COPY ${DEPENDENCY}/META-INF /restservice/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /restservice
ENTRYPOINT ["java","-cp","restservice:restservice/lib/*","restservice.Main"]