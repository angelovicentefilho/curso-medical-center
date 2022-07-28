case $1 in
  "build")

  echo "Creating compiler container"
  docker build . -t medicalcenter-microservices-compiler
  docker run -v $(pwd):/home/compiler/ medicalcenter-microservices-compiler
  docker rmi medicalcenter-microservices-compiler --force

  echo "compiled!"

  ;;
  "run")
    docker-compose -p "medicalcenter-microservices" up -d --force-recreate --build
;;
esac