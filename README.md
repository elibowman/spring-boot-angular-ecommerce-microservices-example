# Spring Boot Microservices

## Services Overview

- Product Service
- Order Service
- Inventory Service
- Notification Service
- API Gateway using Spring Cloud Gateway MVC
- Shop Frontend using Angular 18

## Tech Stack

The technologies used in this project are:

- Spring Boot
- Angular
- Mongo DB
- MySQL
- Kafka
- Keycloak
- Test Containers with Wiremock
- Grafana Stack (Prometheus, Grafana, Loki and Tempo)
- API Gateway using Spring Cloud Gateway MVC
- Kubernetes


## Application Architecture
![image](https://github.com/user-attachments/assets/d4ef38bd-8ae5-4cc7-9ac5-7a8e5ec3c969)

## How to run the frontend application

Make sure you have the following installed on your machine:

- Node.js
- NPM
- Angular CLI

There are two ways to start the frontend application. Choose one:

1. Use npm
```shell
cd frontend
npm install
npm run start
```

2. Build docker image
```shell
cd frontend
docker build -t frontend .
docker tag frontend:latest <your-dockerhub-username>/frontend:latest
docker push <your-dockerhub-username>/frontend:latest
kubectl apply -f k8s/manifests/applications/frontend.yml

# standby and use this command to check until the frontend deployment, service, and pod is in running status
kubectl get all

# then run
kubectl port-forward svc/frontend 4200:80
```

## How to build the backend services

Run the following command to build and package the backend services into a docker container

```shell
mvn spring-boot:build-image -DdockerPassword=<your-docker-account-password>
```

The above command will build and package the services into a docker container and push it to your docker hub account.

## How to run the backend services

Make sure you have the following installed on your machine:

- Java 21
- Docker
- Kind Cluster - https://kind.sigs.k8s.io/docs/user/quick-start/#installation

### Start Kind Cluster

Run the k8s/kind/create-kind-cluster.sh script to create the kind Kubernetes cluster

```shell
./k8s/kind/create-kind-cluster.sh
```
This will create a kind cluster and preload all the required docker images into the cluster, this will save you time downloading the images when you deploy the application.

### Deploy the infrastructure

Run the k8s/manifests/infrastructure path to deploy the infrastructure

```shell
kubectl apply -f k8s/manifests/infrastructure
```

### Deploy the services

Run the k8s/manifests/applications path to deploy the services

```shell
kubectl apply -f k8s/manifests/applications
```

### Access the API Gateway

To access the API Gateway, port-forward your local machine to the API Gateway

```shell
kubectl port-forward svc/api-gateway 9000:9000
```

### Access the Keycloak Admin Console
To access the Keycloak admin console, port-forward your local machine to the keycloak service

```shell
kubectl port-forward svc/keycloak 8080:8080
```

### Access the Grafana Dashboards
To access the Grafana dashboards, port-forward your local machine to the grafana service

```shell
kubectl port-forward svc/grafana 3000:3000
```

### Access the Kafka UI
To access the Kafka UI, port-forward your local machine to the Kafka UI service

```shell
kubectl port-forward svc/kafka-ui 8181:8080
```
