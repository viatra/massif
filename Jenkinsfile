// Tell Jenkins how to build projects from this repository
pipeline {
    agent { 
        label 'matlab'
    }

    parameters {
        choice(choices: 'ci\nrelease', description: '', name: 'BUILD_TYPE')
        string(name: 'VERSION', defaultValue: '0.8.0', description: 'Version of released artifacts (used by release build)')
    }

    environment {
        TEAMS_NOTIFICATION_URL = credentials('massif-teams-channel-url')
    }
	
    // Keep only the last 20 builds
    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }

    tools { 
        maven 'Maven 3.3.9' 
        jdk 'OpenJDK 8' 
    }

    stages {
       stage('Build') { 
            steps {
            	wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
	                configFileProvider([configFile(fileId: 'default-maven-toolchains', variable: 'TOOLCHAIN'), configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
	                    sh "mvn clean install -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=$WORKSPACE/.repository"
	                }
	            }
            }
        }
        stage('Deployment') {
            when {
	        branch "master"
                expression { params.BUILD_TYPE == 'release' }
            }
            steps{
                sh "if [ -d 'massif-install-artifacts' ]; then rm -fr massif-install-artifacts; fi"
                sh "mkdir -p massif-install-artifacts/repository"

                sh "cp -R releng/hu.bme.mit.massif.site/target/repository/* massif-install-artifacts/repository/"
                sh "cp releng/massif.commandevaluation.server-package/target/massif.commandevaluation.server-package*-massif-ce-server.zip massif-install-artifacts/massif.commandevaluation.server-${params.VERSION}.zip"
                sh "cp releng/hu.bme.mit.massif.simulink.cli-package/target/hu.bme.mit.massif.simulink.cli-package-*-massif-cli.zip massif-install-artifacts/hu.bme.mit.massif.simulink.cli-example-${params.VERSION}.zip"
                sshagent(['24f0908d-7662-4e93-80cc-1143b7f92ff1']) {
                    sh 'scp -P 45678 -r massif-install-artifacts/* jenkins@static.incquerylabs.com:/home/jenkins/static/projects/massif/artifacts'
                }
            }
        }
        stage('Set version for Nexus release') {
        	when {
		        branch "master"
        		expression { params.BUILD_TYPE == 'release' }
        	}
        	steps {
                sh "mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=${params.VERSION} -f releng/hu.bme.mit.massif.parent/pom.xml"
        	}
        }
        stage('Deploy to Nexus') {
            when {
		branch "master"
            }
            steps {
                configFileProvider([configFile(fileId: 'default-maven-toolchains', variable: 'TOOLCHAIN'), configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh "mvn clean deploy -pl '!hu.bme.mit.massif:hu.bme.mit.massif.simulink.layout.elk.tests' -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=$WORKSPACE/.repository"
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts 'releng/hu.bme.mit.massif.site/target/repository/**'
            archiveArtifacts 'releng/massif.commandevaluation.server-package/target/massif.commandevaluation.server-package*-massif-ce-server.zip'
            archiveArtifacts 'releng/hu.bme.mit.massif.simulink.cli-package/target/hu.bme.mit.massif.simulink.cli-package-*-massif-cli.zip'
            archiveArtifacts 'docs/hu.bme.mit.massif.doc/html/**'		
        }
      
        success {
            office365ConnectorSend status: "Success",
			color: "00db00",
			webhookUrl: TEAMS_NOTIFICATION_URL
	}
        unstable {
        	office365ConnectorSend status: "Unstable",
			color: "fcb019",
			webhookUrl: TEAMS_NOTIFICATION_URL
        }
        failure {
        	office365ConnectorSend status: "Failure",
			color: "f21607",
			webhookUrl: TEAMS_NOTIFICATION_URL
        }
    }
}
