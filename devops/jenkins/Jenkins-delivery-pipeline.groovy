pipeline {
     agent any
     stages {
          stage('Checkout') {
               steps {
                    git url: 'https://github.com/ZOMELI/API-BS-Exchange-Rate-v1.git'
               }
          }
          stage('Compile') {
               steps {
                    sh "mvn -Dmaven.test.failure.ignore=true install"
               }
          }
     }
}
