#!/bin/sh

echo "********************************************************"
echo "Waiting for the lifeconfsvr server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z lifeconfsvr $CONFIGSERVER_PORT `; do sleep 3; done
echo ">>>>>>>>>>>> Configuration Server has started"

#     -Dsecurity.oauth2.resource.userInfoUri=$AUTHSERVER_URI               \
echo "********************************************************"
echo "Starting Life Friendship Server via Eureka"
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
     -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI             \
     -Dspring.cloud.config.uri=$CONFIGSERVER_URI                          \
     -Dspring.cloud.stream.kafka.binder.zkNodes=$KAFKASERVER_URI          \
     -Dspring.cloud.stream.kafka.binder.brokers=$ZKSERVER_URI             \
     -Dspring.zipkin.baseUrl=$ZIPKIN_URI                                  \
     -Dspring.profiles.active=$PROFILE                                    \
     -jar /usr/local/life/service-friendship/@project.build.finalName@.jar
