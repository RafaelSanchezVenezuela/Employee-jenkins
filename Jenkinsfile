
pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }
    stages {
        stage('gitclone') {
            steps {
                git 'https://github.com/RafaelSanchezVenezuela/Employee-jenkins.git'
            }
        }
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
                sh "docker build -t rafsanz/employee_jenkins:v1 ."
                //sh "docker build -t springboot-docker ."
                //sh "docker run -d -p 8085:8085 -v /var/lib/docker/volumes/volumen-employee/_data:/app/data --name springboot-Employee_container springboot-docker"
            }
        }
        stage('Login') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage ('push image') {
            steps {
                echo "subir imagen a docker hub"
                sh "docker push rafsanz/employee_jenkins:v1"
            }
        }
        stage ('deployment') {
            steps {
                echo "deployment kubernates"
            }
        }
    }
}