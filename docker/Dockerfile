FROM openjdk:8u181-jdk

MAINTAINER suresh26272@gmail.com

# setup group and user, initialize home
RUN addgroup -gid 30002 product-ms && \
	adduser --gid 30002  --system --disabled-login --home /app --shell /sbin/nologin -u 30002 product-ms

COPY product-ms.jar /app

RUN chown -R product-ms /app

EXPOSE 8080

USER product-ms

WORKDIR app

ENTRYPOINT exec java $JAVA_OPTS -jar ./product-ms.jar