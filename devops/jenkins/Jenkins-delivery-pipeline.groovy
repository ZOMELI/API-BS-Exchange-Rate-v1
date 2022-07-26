pipeline {
    stage("build"){
            steps{
                            sh "mvn -f ${PROJECT_ROOT} clean install"
               }
    }
}
