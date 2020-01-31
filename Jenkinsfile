// Tell Jenkins how to build projects from this repository
pipeline {
    agent { 
        label 'matlab'
    }

    parameters {
        choice(choices: 'ci\nrelease', description: '', name: 'BUILD_TYPE')
        string(name: 'VERSION', defaultValue: '0.8.0', description: 'Version of released artifacts (used by release build)')
        booleanParam(defaultValue: true, description: '''This parameter is used to allow not to execute Sonar analysis. It is safe to always make this true, as the Sonar-trigger job will trigger this job without the SKIP_SONAR parameter set daily.''', name: 'SKIP_SONAR') 
    }

    // Keep only the last 20 builds
    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }

    tools { 
        maven 'Maven 3.3.9' 
        jdk 'Oracle JDK 8' 
    }

    stages {
       stage('Build') { 
            steps {
            	wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
	                configFileProvider([configFile(fileId: 'default-maven-toolchains', variable: 'TOOLCHAIN'), configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
	                    sh "mvn clean install -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=$WORKSPACE/.repository"
	                }
	            }
                sh './releng/massif.commandevaluation.server-package/prepareMatlabServerPackage.sh'
                sh './releng/hu.bme.mit.massif.simulink.cli-package/prepareCLIPackage.sh'
            }
        }
        stage('Sonar') {
            when {
                branch "master"
                expression {return !params.SKIP_SONAR }
            }
            steps {
                wrap([$class: 'TimestamperBuildWrapper']) {
                    configFileProvider([
                        configFile(fileId: 'maven-toolchain-oldjdk', variable: 'TOOLCHAIN'),
                        configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
                            withSonarQubeEnv('IncQuery Labs SonarQube') {
                                sh "mvn sonar:sonar -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=$WORKSPACE/.repository -DBUILD_TYPE=${params.BUILD_TYPE} -Dmirror-integration=false -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.scm.disabled=true"
                            }
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
                sh "cp releng/massif.commandevaluation.server-package/massif.commandevaluation.server.zip massif-install-artifacts/massif.commandevaluation.server-${params.VERSION}.zip"
                sh "cp releng/hu.bme.mit.massif.simulink.cli-package/hu.bme.mit.massif.simulink.cli-example.zip massif-install-artifacts/hu.bme.mit.massif.simulink.cli-example-${params.VERSION}.zip"
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
            archiveArtifacts 'releng/massif.commandevaluation.server-package/massif.commandevaluation.server.zip'
            archiveArtifacts 'releng/hu.bme.mit.massif.simulink.cli-package/hu.bme.mit.massif.simulink.cli-example.zip'
            archiveArtifacts 'docs/hu.bme.mit.massif.doc/html/**'		
        }
      
        success {
            office365ConnectorSend message: "Build Successful - ${env.JOB_NAME} <${env.BUILD_URL}>", 
				status:"Success",
				color: "00db00",
				webhookUrl:'https://outlook.office.com/webhook/fb444747-45d9-4919-b1cf-3f172bae2f82@93793c10-3638-4da1-ab66-24d26b844076/JenkinsCI/f11e8c4e653f4a58a5a7cec9caeb9108/67abf680-0958-4541-b58d-90ba41fb4d94'
        }
        unstable {
	    office365ConnectorSend message: "Build Unstable - ${env.JOB_NAME} <${env.BUILD_URL}>", 
				status:"Unstable", 
				color: "fcb019",
				webhookUrl:'https://outlook.office.com/webhook/fb444747-45d9-4919-b1cf-3f172bae2f82@93793c10-3638-4da1-ab66-24d26b844076/JenkinsCI/f11e8c4e653f4a58a5a7cec9caeb9108/67abf680-0958-4541-b58d-90ba41fb4d94'
        }
        failure {
	    office365ConnectorSend message: "Build Failed - ${env.JOB_NAME} <${env.BUILD_URL}>", 
				status:"Failure",
				color: "f21607",
				webhookUrl:'https://outlook.office.com/webhook/fb444747-45d9-4919-b1cf-3f172bae2f82@93793c10-3638-4da1-ab66-24d26b844076/JenkinsCI/f11e8c4e653f4a58a5a7cec9caeb9108/67abf680-0958-4541-b58d-90ba41fb4d94'
        }
    }
}
