"# webservice-yuqing" 
#1.build project 
./mvnw install -Dmaven.test.skip=true dockerfile:build

#2.login docker hub
docker login<br>
->input username ＆ password
#3.push to docker hub
docker push 192.168.0.186:8082/webservice-yuqing:v4.0

#4.pull form docker hub
192.168.0.186:8082/webservice-yuqing:v4.0

#5.run app
docker run -d -p 8888:8888 --name webservice-yuqing -e APP_OPTS=--spring.profiles.active=dev -t 192.168.0.186:8082/webservice-yuqing:v4.0
