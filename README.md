# TP RabbitMQ Consumer

Réalisation d'un TP rabbitMQ avec Spring Boot dans le cadre d'un TP pour le cours de WebService.

## Prérequis

- Docker
- Docker Compose

## Installation et Lancement

### Cloner le Répertoire

Clonez le dépôt Git :

```bash
git clone https://github.com/CelianFrascaYnov/RabbitMQ-Consumer.git
cd RabbitMQ-Consumer
```

## Construire l'Image Docker et Démarrer avec Docker Compose

Construisez l'image Docker et lancer votre application avec :
```bash
docker-compose up --build
```

Votre application devrait maintenant être accessible à l'adresse `http://localhost:8081`.

Mailhog devrait être accessible à l'adresse `http://localhost:8025`.
