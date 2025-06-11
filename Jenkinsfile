pipeline {
    agent any

        stages {
            def app
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
                  app = docker.build("rafsanz/employee_jenkins")
                  //sh "docker build -t springboot-docker ."
                  //sh "docker run -d -p 8085:8085 -v /var/lib/docker/volumes/volumen-employee/_data:/app/data --name springboot-Employee_container springboot-docker"
                }
            }
            stage ('push image') {
                steps {
                  echo "subir imagen a docker hub"
                  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                              app.push("${env.BUILD_NUMBER}")
                }
            }
            stage ('deployment') {
                steps {
                  echo "deployment kubernates"
                }
            }
        }
}