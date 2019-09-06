pipeline {
   //Donde se va a ejecutar el Pipeline
   agent {
       label 'Slave_Induccion'
   }
   
   options {
       buildDiscarder(logRotator(numToKeepStr: '3'))
       disableConcurrentBuilds()
   }
   
   tools {
       jdk 'JDK8_Centos'
       gradle 'Gradle4.5_Centos'
   }
   
   stages{
       stage('Checkout') {
           steps{ 
               echo "------------>Checkout<------------"
               checkout([$class: 'GitSCM',
                        branches: [[name: '*/master']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        gitTool:'Git_Centos',
                        submoduleCfg: [],
                        userRemoteConfigs: [[credentialsId:'GitHub_andres0218',
                        url:'https://github.com/andresorozco427/BODEGA_ADN_CEIBA.git']]])
           }  
       }
       stage('Unit Tests') {
           steps{
               echo "------------>Unit Tests<------------"
               sh 'gradle --b ./infraestructura/build.gradle test'
               sh 'gradle --b ./aplicacion/build.gradle test'
               sh 'gradle --b ./dominio/build.gradle test'
           }
       }
       stage('Integration Tests') {
           steps {
               echo "------------>Integration Tests<------------"
           }
       }
       stage('Static Code Analysis') {
           steps{
               echo '------------>Analisis de codigo estatico<------------'
               withSonarQubeEnv('Sonar') {
                   sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"}
           }
       }
   
       stage('Build') {
           steps {
               echo "------------>Build<------------"
               sh 'gradle --b ./infraestructura/build.gradle build -x test'
               sh 'gradle --b ./aplicacion/build.gradle build -x test'
               sh 'gradle --b ./dominio/build.gradle build -x test'
           } 
       }
   }
 
	   post {
	         always {
	             echo 'This will always run'
	         }
	         success {
	             echo 'This will run only if successful'
	             junit 'build/test-results/test/*.xml'
	         }
		         failure {
	 		echo 'This will run only if failed' 
	 		mail (to: 'andres.orozco@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
	 		body: "Something is wrongwith ${env.BUILD_URL}")
	 		}
		 }
	       
  }