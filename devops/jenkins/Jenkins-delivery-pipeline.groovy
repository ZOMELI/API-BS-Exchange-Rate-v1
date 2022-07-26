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
                steps{
                                sh "mvn -f ${PROJECT_ROOT} clean install"
                   }
        }
    }
}
