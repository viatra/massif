FROM openjdk:8-jdk

ARG MAVEN_VERSION=3.6.3
ARG USER_HOME_DIR="/root"
ARG SHA=c35a1803a6e70a126e80b2b3ae33eed961f83ed74d18fcd16909b2d44d7dada3203f1ffe726c17ef8dcca2dcaa9fca676987befeadc9b9f759967a8cb77181c0
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
ARG VNC_PASSWORD

ENV USER root
USER root

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn \
  && apt-get update; apt-get install -y tightvncserver libgtk2.0 \
  && mkdir -p /root/.vnc; (echo ${VNC_PASSWORD}|vncpasswd -f > /root/.vnc/passwd) \
  && chmod 700 /root/.vnc; chmod 600 /root/.vnc/passwd

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

#COPY vnc-mvn-entrypoint.sh /usr/local/bin/vnc-mvn-entrypoint.sh
#COPY entrypoint.sh /usr/local/bin/entrypoint.sh
#COPY settings-docker.xml /usr/share/maven/ref/

#RUN chmod +x /usr/local/bin/vnc-mvn-entrypoint.sh
#RUN chmod +x /usr/local/bin/entrypoint.sh

#ENTRYPOINT ["/usr/local/bin/vnc-mvn-entrypoint.sh"]
#ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
RUN echo $GITHUB_WORKSPACE && ls -l /home/

RUN chmod +x ["${GITHUB_WORKSPACE}/entrypoint.sh"] 
ENTRYPOINT ["${GITHUB_WORKSPACE}/entrypoint.sh"]
