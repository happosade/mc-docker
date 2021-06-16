# Minecraft server on docker

This minecraft server runs in docker with Java 16.
Together with spigotmc it should provide smoother experience when
it comes to running MC server without hogging too much resources.

## Running

Change the row on `server.properties` to have
`enable-jmx-monitoring=true` in order to get exporter to work correctly.
