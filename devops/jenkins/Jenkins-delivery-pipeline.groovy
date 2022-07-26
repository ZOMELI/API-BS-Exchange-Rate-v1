pipeline {
    agent any 
    tools { 
        maven 'MAVEN' 
        jdk 'JDK' 
    }
    stages{
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        
        stage("build"){
               git url: 'https://github.com/ZOMELI/API-BS-Exchange-Rate-v1'
                withMaven {
                  sh "mvn clean install"
                } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
        }
    }
}
