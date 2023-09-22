FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

RUN apk add --update --no-cache ttf-dejavu fontconfig && rm -rf /var/cache/apk/*
RUN adduser -D -s /bin/sh sadad
WORKDIR /home/Natflix
# add directly the war
ADD *.war app.war

EXPOSE 8085 5701/udp

