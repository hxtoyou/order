def git_auth = "hxtome"
def git_url = "git@github.com:hxtoyou/order.git"
def tag = "latest"
def harbor_url = "192.168.1.8:85"
def harbor_project = "hxtome"
def harbor_auth = "0467797b-39bb-4123-b3e5-93e2481aee68"
node{
    stage('拉取代码') {
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
    }
    stage('编译安装子工程') {
        sh "mvn -f order-common clean install -Dmaven.test.skip=true"
    }
    stage('编译打包微服务工程') {
        sh "mvn -f ${project_name} clean package -Dmaven.test.skip=true dockerfile:build"
        def imageName = "${project_name}:${tag}"
        sh "docker tag ${imageName} ${harbor_url}/${harbor_project}/${imageName}"
        //推送镜像到harbor
        withCredentials([usernamePassword(credentialsId: '${harbor_auth}', passwordVariable: 'password', usernameVariable: 'username')]) {
            // some block
            sh "docker login -u ${username} -p ${password} ${harbor_url}"
            sh "docker push ${harbor_url}/${harbor_project}/${imageName}"
            sh "echo 镜像上传成功"
        }
    }
}