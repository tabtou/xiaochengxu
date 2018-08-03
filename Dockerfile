FROM frolvlad/alpine-oraclejdk8:slim
COPY target/wxiaochengxu-1.0-SNAPSHOT.jar xiaochengxu.jar
ENV JAVA_OPTS=""
ENV APP_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /wxiaochengxu.jar $APP_OPTS" ]
EXPOSE 8888