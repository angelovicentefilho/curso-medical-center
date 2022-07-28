#!/bin/bash

while :
do
  status_code=$(curl --write-out %{http_code} --silent --output /dev/null http://medical-center-config-server:8888/api-gateway/dev)
  
  echo "Config service response: $status_code"
  
  if [ $status_code -eq 200 ]
  then
      java -jar service-discovery.jar
      break
  fi
  
  sleep 3
done