def git_auth = "hxtome"
def git_url = "git@github.com:hxtoyou/order.git"
node{
    stage('拉取代码') {
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
    }
}