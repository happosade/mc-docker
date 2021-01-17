FROM adoptopenjdk:15.0.1_9-jre-hotspot AS build
WORKDIR /minecraft
RUN apt update &&\
    apt install -y curl git &&\
    curl -LO https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
RUN java -jar BuildTools.jar
RUN rm -rf apache-maven-3.6.0/ Build*

FROM adoptopenjdk:15.0.1_9-jre-hotspot
WORKDIR /minecraft
COPY --from=build /minecraft /minecraft
COPY start.sh .

RUN echo "eula=true" > eula.txt
CMD ["./start.sh"]