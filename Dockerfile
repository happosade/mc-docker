FROM adoptopenjdk:15.0.1_9-jre-hotspot AS build
WORKDIR /minecraft
RUN apt update &&\
    apt install -y curl git &&\
    curl -LO https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar &&\
    curl -LO https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/0.14.0/jmx_prometheus_javaagent-0.14.0.jar
RUN java -jar BuildTools.jar
RUN rm -rf apache-maven-3.6.0/ Build* work

FROM adoptopenjdk:15.0.1_9-jre-hotspot
WORKDIR /minecraft
COPY --from=build /minecraft /minecraft
COPY config.yaml .
COPY start.sh .
CMD ["./start.sh"]