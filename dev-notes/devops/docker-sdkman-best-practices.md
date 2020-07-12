# Instalar Sdkman

```dockerfile
FROM debian:stretch-slim

# Defining default Java and Maven version
ARG JAVA_VERSION="11.0.6-amzn"
ARG MAVEN_VERSION="3.6.2"

# Defining default non-root user UID, GID, and name
ARG USER_UID="1000"
ARG USER_GID="1000"
ARG USER_NAME="jenkins"

# Creating default non-user
RUN groupadd -g $USER_GID $USER_NAME && \
	useradd -m -g $USER_GID -u $USER_UID $USER_NAME

# Installing basic packages
RUN apt-get update && \
	apt-get install -y zip unzip curl && \
	rm -rf /var/lib/apt/lists/* && \
	rm -rf /tmp/*

# Switching to non-root user to install SDKMAN!
USER $USER_UID:$USER_GID

# Downloading SDKMAN!
RUN curl -s "https://get.sdkman.io" | bash

# Installing Java and Maven, removing some unnecessary SDKMAN files
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install java $JAVA_VERSION && \
    yes | sdk install maven $MAVEN_VERSION && \
    rm -rf $HOME/.sdkman/archives/* && \
    rm -rf $HOME/.sdkman/tmp/*"

# ENTRYPOINT bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && $0 $@"

ENV MAVEN_HOME="/home/jenkins/.sdkman/candidates/maven/current"
ENV JAVA_HOME="/home/jenkins/.sdkman/candidates/java/current"
ENV PATH="$MAVEN_HOME/bin:$JAVA_HOME/bin:$PATH"
```

Ejecutar

`$ docker build --build-arg JAVA_VERSION=8.0.232-amzn …`

`$ docker build -t sdkman:local .`

`$ docker run --rm -u $(id -u) sdkman:local java -version`

Jenkinsfile

```json
pipeline {
    agent {
        docker {
            image "sdkman:local"
        }
    }
    stages {
        stage("Build") {
            steps {
                sh "java -version"
                sh "mvn -version"
            }
        }
    }
}
```

Ejemplos de contenedores de docker con Sdkman

```bash
$ docker build -q --build-arg JAVA_VERSION=11.0.5-amzn --build-arg MAVEN_VERSION=3.5.4 -t sdkman:mvn-3.5.4-jdk-11.0.5-amzn .
sha256:fc6006992d79314758b0726f226cc5e87355708b9b7348e89599594b2b881d7c

$ docker build -q --build-arg JAVA_VERSION=11.0.5-amzn --build-arg MAVEN_VERSION=3.6.2 -t sdkman:mvn-3.6.2-jdk-11.0.5-amzn .
sha256:1e1699b478f404c66ed9cf75d122cd941f49e74de3c6e14d25520edfd8fd204b

$ docker build -q --build-arg JAVA_VERSION=13.0.1-zulu --build-arg MAVEN_VERSION=3.5.4 -t sdkman:mvn-3.5.4-jdk-13.0.1-zulu .
sha256:e804b0e7a71bc630d9c590c0e6c714155a7fbc46353b626720f7e53e8e7808c0

$ docker build -q --build-arg JAVA_VERSION=13.0.1-zulu --build-arg MAVEN_VERSION=3.6.2 -t sdkman:mvn-3.6.2-jdk-13.0.1-zulu .
sha256:d08fbd4ef3f889b0739d83d71e1d1f9da9bbf09b5d50d9418b661db6d8be80c7

$ docker run --rm -u $(id -u) sdkman:mvn-3.5.4-jdk-11.0.5-amzn mvn -version
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T18:33:14Z)
Maven home: /home/jenkins/.sdkman/candidates/maven/current
Java version: 11.0.5, vendor: Amazon.com Inc., runtime: /home/jenkins/.sdkman/candidates/java/11.0.5-amzn
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "5.3.8-200.fc30.x86_64", arch: "amd64", family: "unix"

$ docker run --rm -u $(id -u) sdkman:mvn-3.6.2-jdk-13.0.1-zulu mvn -version
Apache Maven 3.6.2 (40f52333136460af0dc0d7232c0dc0bcf0d9e117; 2019-08-27T15:06:16Z)
Maven home: /home/jenkins/.sdkman/candidates/maven/current
Java version: 13.0.1, vendor: Azul Systems, Inc., runtime: /home/jenkins/.sdkman/candidates/java/13.0.1-zulu
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "5.3.8-200.fc30.x86_64", arch: "amd64", family: "unix"
```
