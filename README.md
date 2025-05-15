Book-Service Project

📋 Introduction

Le projet Book-Service est une application distribuée basée sur Spring Boot, Docker, et Kubernetes. Ce projet a été conçu pour explorer les concepts de la programmation distribuée, y compris la conteneurisation, l'orchestration et la sécurité des microservices.

🚀 Fonctionnalités principales

API REST pour gérer des livres et des auteurs

Base de données PostgreSQL pour le stockage persistant

Déploiement sur un cluster Kubernetes

Sécurisation des services avec mTLS, RBAC et analyse des vulnérabilités

🛠️ Prérequis

Avant de commencer, assurez-vous d'avoir les outils suivants installés :

Git (pour cloner le projet)

Docker (pour créer et exécuter des conteneurs)

Minikube ou Kind (pour simuler un cluster Kubernetes local)

kubectl (pour interagir avec le cluster Kubernetes)

Helm (facultatif, pour la gestion des déploiements Kubernetes)

📂 Installation et Configuration

1. Cloner le projet

git clone https://github.com/larbi01/book-store.git
cd book-store

2. Configuration des bases de données

Assurez-vous que PostgreSQL est configuré correctement pour les deux services (Book-Service et Author-Service). Vous pouvez utiliser les fichiers YAML fournis :

cd book-service/k8s
kubectl apply -f postgres-deployment.yml
cd ../../author-service/k8s
kubectl apply -f postgres-deployment.yml

3. Construction des images Docker

cd book-service
mvn clean package
cd ../author-service
mvn clean package

Construisez ensuite les images Docker :

docker build -t book-service:latest ./book-service

docker build -t author-service:latest ./author-service

4. Déploiement sur Kubernetes

Créez les déploiements et services Kubernetes :

cd book-service/k8s
kubectl apply -f deployment.yml
kubectl apply -f service.yml

cd ../../author-service/k8s
kubectl apply -f deployment.yml
kubectl apply -f service.yml

Vérifiez que les pods sont en cours d'exécution :

kubectl get pods

5. Vérification des services

Vous pouvez vérifier que les services sont accessibles avec les commandes suivantes :

kubectl get services

Accédez à votre service en utilisant l'adresse IP de Minikube ou en configurant un Ingress.

🔐 Sécurisation du cluster

Vous pouvez sécuriser votre cluster avec les outils suivants :

kube-bench  pour vérifier les configurations de sécurité Kubernetes

kube-hunter pour identifier les failles de sécurité potentielles

Trivy pour scanner les images Docker contre les vulnérabilités

📚 Améliorations futures

Intégration d'une interface utilisateur en HTML/CSS pour une meilleure expérience utilisateur

Automatisation des tests avec Argo CD

Surveillance des logs et des métriques

📝 Conclusion

Ce projet est une excellente introduction à la programmation distribuée et à la gestion des microservices. N'hésitez pas à forker, contribuer et améliorer ce projet ! 😊
