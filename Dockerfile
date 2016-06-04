FROM tomcat:8-jre8

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY build/libs/fixit-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]