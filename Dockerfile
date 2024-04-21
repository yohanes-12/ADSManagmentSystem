FROM ubuntu:latest
LABEL authors="yohanes"

ENTRYPOINT ["top", "-b"]

# Start with a base image containing Java runtime (specify the Java version you need)
FROM openjdk:22

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Add the application's jar to the container
ADD target/class/com/ads/adsmanagment/adsmanagment-0.0.1-SNAPSHOT.jar myapplication.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/AdsmAnagmentApplication.jar"]