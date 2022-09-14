pipeline {
  agent {
    kubernetes {
      label 'jenkins-slave-builder'
      yamlFile 'builder-pod.yml'
    }
  }

  options {
    timestamps()
    ansiColor('xterm')
    disableConcurrentBuilds()
  }

  environment {
    DOCKER_REGISTRY = "ghcr.io"
    REGISTRY_CRED   = "github.ci.username.password"
    REPO_URL        = "doka-mb"
    IMAGE_NAME      = "doka-reporting"
    DOCKER_BUILDKIT = "1"
  }

  stages {
    stage("Get Build Number") {
      steps {
        script {
          timestamp = sh(returnStdout: true, script: "TZ=UTC-3 date '+%Y%m%d-%H%M%S'").trim()

          //  remove feature folder from branch name
          env.branchName = env.BRANCH_NAME - ~/^feature\//
          env.buildNumber = "${env.branchName}-${timestamp}-${env.BUILD_NUMBER}".toLowerCase()

          print("Build number is generated to be ${env.buildNumber}")
        }
      }
    }

    stage('Build Docker Images') {
      steps {
        container('docker') {
          script {
            docker.build("${DOCKER_REGISTRY}/${REPO_URL}/${env.IMAGE_NAME}:${env.buildNumber}", "-f Dockerfile .")
          }
        }
      }
    }

    stage('Push Docker Images') {
      steps {
        container('docker') {
          script {
            docker.withRegistry("https://${DOCKER_REGISTRY}", env.REGISTRY_CRED) {
              docker.image("${DOCKER_REGISTRY}/${REPO_URL}/${env.IMAGE_NAME}:${env.buildNumber}").push()
            }
          }
        }
      }
    }
    stage('Trigger Dev Deployment of Currently Built Version') {
          when {
            expression { env.BRANCH_NAME == 'development' }
          }
          steps {
            build job: 'Dev Env Deploy/Doka Reporting Deploy',
              wait: false,
              parameters: [
                [
                  $class: 'StringParameterValue',
                  name: 'NEW_TAG',
                  value: "${env.buildNumber}"
                ]
              ]
          }
        }

     stage('Trigger Dev B Deployment of Currently Build Version') {
      when {
        expression { env.BRANCH_NAME == 'development'}
      }
      steps {
        build job: 'Dev-b Env Deploy/Doka Reporting Deploy',
          wait: false,
          parameters: [
            [
            $class: 'StringParameterValue',
            name: 'NEW_TAG',
            value: "${env.buildNumber}"
            ]
          ]
      }
    }

    stage('Trigger Prod Deployment of Currently Built Version') {
          when {
            expression { env.BRANCH_NAME == 'master' }
          }
          steps {
            build job: 'Prod A Env Deploy/Doka Reporting Deploy',
              wait: false,
              parameters: [
                [
                  $class: 'StringParameterValue',
                  name: 'NEW_TAG',
                  value: "${env.buildNumber}"
                ]
              ]
          }
        }

    stage('Trigger QA Deployment of Currently Built Version') {
          when {
            expression { env.BRANCH_NAME == 'QA' }
          }
          steps {
            build job: 'QA Env Deploy/Doka Reporting Deploy',
              wait: false,
              parameters: [
                [
                  $class: 'StringParameterValue',
                  name: 'NEW_TAG',
                  value: "${env.buildNumber}"
                ]
              ]
          }
        }
  }
}
