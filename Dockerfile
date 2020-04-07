FROM openjdk:8-jre-alpine

RUN apk update \
    && apk upgrade

RUN mkdir /usr/share/dict

COPY words /usr/share/dict/words
COPY target/wordsCombo-1.0-SNAPSHOT.jar /combo.jar

CMD java -jar /combo.jar