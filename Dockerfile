FROM openjdk:8-jdk

ARG MAVEN_VERSION=3.6.3
ARG USER_HOME_DIR="/root"
ARG SHA=c35a1803a6e70a126e80b2b3ae33eed961f83ed74d18fcd16909b2d44d7dada3203f1ffe726c17ef8dcca2dcaa9fca676987befeadc9b9f759967a8cb77181c0
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
ARG VNCPASS
ARG SSH_PRIVATE_KEY

ENV USER root
USER root

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn \
  && apt-get update; apt-get install -y tightvncserver libgtk2.0 \
  && mkdir -p /root/.vnc; (echo ${VNCPASS}|vncpasswd -f > /root/.vnc/passwd) \
  && chmod 700 /root/.vnc; chmod 600 /root/.vnc/passwd; mkdir -p /root/massif/

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG /.m2

COPY / /root/massif/
COPY /.m2/toolchains.xml ~/.m2/toolchains.xml
ENV GITHUB_WORKSPACE /root/massif

#COPY vnc-mvn-entrypoint.sh /usr/local/bin/vnc-mvn-entrypoint.sh
#COPY entrypoint.sh /usr/local/bin/entrypoint.sh
#COPY settings-docker.xml /usr/share/maven/ref/

#RUN chmod +x /usr/local/bin/vnc-mvn-entrypoint.sh
#RUN chmod +x /usr/local/bin/entrypoint.sh

#ENTRYPOINT ["/usr/local/bin/vnc-mvn-entrypoint.sh"]
#ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]

RUN chmod +x /root/massif/entrypoint.sh; echo $JAVA_HOME; cat /.m2/toolchains.xml 
RUN /root/massif/./entrypoint.sh
#ENTRYPOINT ["/root/massif/entrypoint.sh"]

