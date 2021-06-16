FROM adoptopenjdk:16.0.1_9-jre-hotspot AS downloader
WORKDIR /minecraft
RUN apt-get update &&\
    apt-get install -y curl &&\
    curl -LO https://download.getbukkit.org/spigot/spigot-1.17.jar &&\
    curl -LO https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/0.15.0/jmx_prometheus_javaagent-0.15.0.jar

FROM adoptopenjdk:16.0.1_9-jre-hotspot
WORKDIR /minecraft
COPY --from=downloader /minecraft /minecraft
COPY config.yaml .
COPY start.sh .
CMD ["./start.sh"]