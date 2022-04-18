def git_auth = "hxtome"
def git_url = "git@github.com:hxtoyou/order.git"
node{
    stage('拉取代码') {
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
    }
    stage('编译安装子工程') {
        sh "mvn -f order-common clean install"
    }
    stage('编译打包微服务工程') {
        sh "mvn -f ${project_name} clean package"
    }
}