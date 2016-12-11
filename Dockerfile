FROM openjdk:8-jdk
MAINTAINER Saurabh Malik <saurabh.malik1@globallogic.com>

# RUN apt-get update && apt-get install -y curl && apt-get clean && rm -rf /var/lib/apt/lists

# unzip
# RUN apt-get update && apt-get install --yes unzip

# Gradle
ENV GRADLE_VERSION 2.13
ENV GRADLE_SHA 0f665ec6a5a67865faf7ba0d825afb19c26705ea0597cec80dd191b0f2cbb664

RUN cd /usr/lib \
 && curl -fl https://downloads.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle-bin.zip \
 && echo "$GRADLE_SHA gradle-bin.zip" | sha256sum -c - \
 && unzip "gradle-bin.zip" \
 && ln -s "/usr/lib/gradle-${GRADLE_VERSION}/bin/gradle" /usr/bin/gradle \
 && rm "gradle-bin.zip"

# Set Appropriate Environmental Variables
ENV GRADLE_HOME /usr/lib/gradle
ENV PATH $PATH:$GRADLE_HOME/bin


# Default command is "/usr/bin/gradle -version" on /usr/bin/app dir
# (ie. Mount project at /usr/bin/app "docker --rm -v /path/to/app:/usr/bin/app gradle <command>")
WORKDIR /usr/bin/app
ADD /. /usr/bin/app
RUN ls
RUN ["gradle", "clean", "build"]
RUN ls
# Caches
#VOLUME ["/root/.gradle/caches"]


#VOLUME /tmp
WORKDIR /tmp
# RUN cd build/libs \ && ls
RUN mv /usr/bin/app/build/libs/customer-core-service.jar /tmp/app.jar
#ADD build/libs/app.jar app.jar
RUN ls
#ADD build/libs/app.jar tmp/app.jar
#RUN ls

RUN /bin/bash -c 'touch /tmp/app.jar'
EXPOSE 8094
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/app.jar"]
