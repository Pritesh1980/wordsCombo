[![Build Status](https://pritesh1980.visualstudio.com/WordsCombo/_apis/build/status/Pritesh1980.wordsCombo?branchName=master)](https://pritesh1980.visualstudio.com/WordsCombo/_build/latest?definitionId=1&branchName=master)
# wordsCombo
Word Combination Generator

This project generates 6 digit numbers from words such that A=1, B=2...J=0, K=1 etc.
Additionally, it takes a 6 digit number and works out the possible words that this could have come from.

It is a simple app, mostly used so I can test unit testing frameworks, code coverage and profiling tools as well as various CI/CD pipelines - local and on Cloud platforms.

# SpringBoot
Updated to run as a SpringBoot application, with endpoints available via :8080/words and :8080/numbers

e.g. localhost:8080/words/random

# Docker
This app can now run in a Docker container.

Usage:
- Build: `docker build -t combo:0.0.1 .`
- Run: `docker run -p 8080:8080 combo:0.0.1`

# Swagger
Swagger now added.
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v2/api-docs

# Kubernetes
Kubernetes deployment and service configurations are in the k8s folder

Usage examples:
- `kubectl get pods`
- `kubectl apply -f deployment.yml`
- `kubectl get pods`
- `kubectl get deployments`
- `kubectl describe deployment combo-deploy`
- `kubectl scale --replicas=2 deployment/combo-deploy`
- `kubectl describe deployment combo-deploy`
- `kubectl create -f service.yml`
- `kubectl get services`
- `kubectl port-forward service/combo-service 8081:80`
- `kubectl delete deployment combo-deploy`
- `kubectl delete service combo-service`
- `kubectl delete service combo-service`