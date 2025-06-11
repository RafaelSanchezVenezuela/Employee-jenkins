pipeline {
    agent any

        stages {

            stage ('test') {
                steps {
                  sh "mvn clean compile test"
                }
            }
            stage ('Build application') {
                steps {
                  sh "mvn -f pom.xml clean install -Dmaven.test.skip=true"
                }
            }
            stage ('Create docker image') {
                steps {
                  echo "creando docker"
                  sh "docker build -t springboot-docker ."
                  sh "docker run -d -p 8085:8085 -v /var/lib/docker/volumes/volumen-employee/_data:/app/data --name springboot-Employee_container springboot-docker"
                }

            }
        }
}