#!/bin/sh -l

vncserver :1 -geometry 1280x800 -depth 24
vnc_pid=$!
export DISPLAY=:1

export GTK_IM_MODULE="ibus"
mvn clean install -B -e -X -f ${GITHUB_WORKSPACE}/releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=.repository
