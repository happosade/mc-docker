#!/bin/bash

java -XX:+UseShenandoahGC \
     -XX:MaxRAMPercentage=80 \
     -XX:InitialRAMPercentage=100 \
     -XX:+AlwaysPreTouch \
     -jar spigot-1.16.5.jar nogui
