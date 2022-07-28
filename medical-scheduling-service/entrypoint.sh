#!/bin/bash

while :
do
  status_code=$(curl --write-out %{http_code} --silent --output /dev/null http://medical-center-service-discovery:8761)
  status_code_config=$(curl --write-out %{http_code} --silent --output /dev/null http://medical-center-config-server:8888/api-gateway/dev)

  echo "Eureka service response: $status_code\n"
  echo "Config service response: $status_code_config"

  if [ $status_code -eq 401 ] && [ $status_code_config -eq 200 ]
  then
    java -jar scheduling-service.jar
    break
  fi

  sleep 3
done