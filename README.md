# SIG Santé Publique (sig-rs)

Ce projet est un Système d'Information Géographique (SIG) dédié à la gestion et la visualisation de cas de maladies, basé sur Spring Boot, PostgreSQL/PostGIS et Leaflet pour la cartographie interactive.

## Fonctionnalités

- Enregistrement de cas de maladies avec localisation (latitude/longitude)
- API REST pour la gestion des cas
- Visualisation des cas sur une carte interactive (frontend simple avec Leaflet)

## Prérequis

- Java 17 ou plus
- Maven
- PostgreSQL avec l'extension PostGIS

## Installation

### 1. Préparer la base de données

```sql
CREATE DATABASE sigdb;
\c sigdb
CREATE EXTENSION IF NOT EXISTS postgis;
```

Modifiez `src/main/resources/application.properties` selon vos identifiants PostgreSQL si besoin.

### 2. Lancer l'application Spring Boot

```sh
mvn spring-boot:run
```

### 3. Ajouter un cas de maladie

```sh
curl -X POST http://localhost:8080/api/cas -H "Content-Type: application/json" -d '{"nom":"Choléra","description":"Cas confirmé","latitude":7.7,"longitude":-5.0}'
```

### 4. Visualiser sur la carte

Ouvrez `frontend/index.html` dans votre navigateur pour voir les cas sur la carte.

## Frontend

Le frontend minimal fourni utilise [Leaflet.js](https://leafletjs.com/) et interroge l'API REST du backend pour afficher les cas sur la carte.

## Personnalisation

- Ajoutez d'autres modèles de données selon vos besoins
- Améliorez le frontend (React, Angular, etc.)
- Ajoutez des requêtes spatiales, statistiques, filtres, etc.

## Licence

MIT
