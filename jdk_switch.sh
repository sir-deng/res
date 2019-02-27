#!/bin/sh
echo ‘start eclipse’
case $1 in
    jdk8) export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
 ;;
    jdk9) export JAVA_HOME=/usr/lib/jvm/java-8-oracle/
 ;;
    jdk7) export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64
 ;;
    jdk6) export JAVA_HOME=/usr/lib/jvm/java-6-oracle/
 ;;
    *) export JAVA_HOME=/usr/lib/jvm/java-9-openjdk-amd64/
 ;;
esac
echo $JAVA_HOME
export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH
export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib

java -version
