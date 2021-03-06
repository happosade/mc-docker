#!/bin/bash

java -javaagent:./jmx_prometheus_javaagent-0.14.0.jar=8081:config.yaml \
     -XX:+UseShenandoahGC \
     -XX:MaxRAMPercentage=80 \
     -XX:InitialRAMPercentage=100 \
     -XX:+AlwaysPreTouch \
     -Dcom.sun.management.jmxremote \
     -Dcom.sun.management.jmxremote.port=5555 \
     -Dcom.sun.management.jmxremote.rmi.port=5555 \
     -Dcom.sun.management.jmxremote.authenticate=false \
     -Dcom.sun.management.jmxremote.ssl=false \
     -jar spigot-1.16.5.jar nogui
