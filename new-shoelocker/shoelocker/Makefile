all: clean

clean:
	gradle clean

compile:
	gradle build

test:
	gradle test

jar: 
	gradle build -x test
	gradle bootJar

run: jar
	echo Starting Spring at:  http://localhost:8080
	java -jar build/libs/spring-gumball-3.0.jar

# MySQL DB


mysql:
	docker run -d --network gumball --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

mysql-shell:
	docker exec -it mysql bash 


# Docker

docker-build: jar
	docker build -t spring-gumball-v3.0 .
	docker images

gumball-network:
	docker network create --driver bridge gumball-v3.0

docker-run: docker-build
	docker run --network gumball -e "MYSQL_HOST=mysql" --name spring-gumball-v3.0 -td -p 8080:8080 spring-gumball-v3.0	

docker-clean:
	docker stop spring-gumball
	docker rm spring-gumball
	docker rmi spring-gumball

docker-shell:
	docker exec -it spring-gumball bash 

docker-push:
	docker login
	docker build -t richpham/spring-gumball:v3.0 -t richpham/spring-gumball:v3.0 .
	docker push richpham/spring-gumball:v3.0 

# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge spring-gumball-v3.0_network

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale gumball=2 -d

lb-up:
	docker-compose up -d lb 

gumball-up:
	docker-compose up -d gumball

mysql-up:
	docker-compose up -d mysql 

compose-down:
	docker-compose down 	

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost


# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-gumball

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-gumball -- /bin/bash

pod-logs:
	kubectl logs -f spring-gumball

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-gumball

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-gumball-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-gumball -o wide

service-delete:
	kubectl delete service spring-gumball

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-gumball-ingress




