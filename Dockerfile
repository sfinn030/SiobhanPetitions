FROM tomcat:latest
ADD target/*.war /usr/local/tomcat/webapps/
EXPOSE 8082
CMD ["catalina.sh", "run"]