FROM dostiharise/ubuntu-java-mysql

MAINTAINER Igor Moura

COPY ./target /home/igor/spotippos

WORKDIR /home/igor/spotippos/

ENTRYPOINT java -jar spotippos-0.0.1-SNAPSHOT.jar

EXPOSE 8080