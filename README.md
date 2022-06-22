# Projet_Programmation_distribu-
This repository is for showing how this project works.

L’objectif est de créer un système distribué basé sur les micro-services permettant de gérer les factures des clients en utilisant la même architecture que vous avez déjà développé auparavant en y intégrant un système de sécurité basé sur Keycloak, Un Bus de messagerie avec KAFKA, un service de Stream processing avec Kafka Streams et un service de Batch Processing avec Spring Batch.

![image (1)](https://user-images.githubusercontent.com/84507906/172048467-bdd777a0-0aa4-4a00-b352-ce87e87a274e.png)



J'ai réalisé les taches suivantes dans le projet de la programmation distribuée

Les taches réaliser et explication

Architecture Micro-services :

<h3>Customer-Service</h3>
La creation du micro service qui gere les clients et qui s'applique dans le port 8087

![image](https://user-images.githubusercontent.com/84507906/175099030-dfa24d84-9a3b-4b38-a6cc-255fe6626cdf.png)

fetch data pour le micro-service des clients ou il communique avec la base de données des cient et return les valeurs

![FetchDataConsumerService](https://user-images.githubusercontent.com/84507906/175098685-d5146eb5-be33-4e4e-b41d-3eae6b4907c9.PNG)

<h3>Inventory-Service</h3>

La creation du micro service qui gere les produits et qui s'applique dans le port 8082

![image](https://user-images.githubusercontent.com/84507906/175126391-ae94c3ea-8d09-4eb7-aea6-cc86688fe2de.png)

fetch data pour le micro-service des produits ou il communique avec la base de données des produits et return les valeurs

![FetchDataProdectService](https://user-images.githubusercontent.com/84507906/175098691-178596bb-43e1-4b39-afbc-6a5aeb3b6097.PNG)

<h3>Billing-Service</h3>

La creation du micro service qui gere les produits et qui s'applique dans le port 8083

![image](https://user-images.githubusercontent.com/84507906/175127454-1a05cb46-2092-482a-a1c5-f096433d7a71.png)

<h3>Eureka Discovery Service</h3>

Eureka Server est une application qui contient les informations sur toutes les applications de service client. Chaque service Micro s’enregistre sur le serveur Eureka et le serveur Eureka connaît toutes les applications clientes en cours d’exécution sur chaque port et adresse IP. Eureka Server est également connu sous le nom de Discovery Server.

La creation de Eureka Discovery Service

![image](https://user-images.githubusercontent.com/84507906/175129996-c1cd3676-501b-4d86-a286-76b4613b0ddb.png)

<h3>Spring Cloud Gateway</h3>

Spring Cloud Gateway est destiné à se situer entre un demandeur et une ressource demandée, où il intercepte, analyse et modifie chaque demande

La creation de Spring Cloud Gateway

![image](https://user-images.githubusercontent.com/84507906/175131186-45ba114a-e6d8-47d0-b2c5-3a815a78096d.png)



<h5>Sécurité des systèmes distribués avec Keycloak</h5>

·       Part 1 : https://www.youtube.com/watch?v=w3W1bQdVJco

·       Part 2 : https://www.youtube.com/watch?v=tfERGzx-Jqs

Event Driven Architecture avec KAFKA

·       Part 1 : https://www.youtube.com/watch?v=dXJEzisrFZo

·       Part 2 : https://www.youtube.com/watch?v=eo8pSWpj2os

Travail à faire

1.       Mettre en place les micro-services

a.       Customer-Service

b.       Inventory-Service

c.       Billing-Service

d.       Eureka Discovery Service

e.       Spring Cloud Gateway

2.       Mise en place du service de Sécurité avec Keycloak

o   Mettre en place le serveur d’authentification OAuth2 Keycloak version 12.0.1

o   Créer un Realm,

o   Le client à sécuriser en mode public client

o   Créer les rôles (USER, ADMIN, PRODUCT_MANAGER, CUSTOMER_MANAGER et BILLING_MANAGER)

o   Créer quelques utilisateurs

o   Affecter les rôles aux utilisateurs

o   Tester l’authentification des utilisateurs en utilisant un client Rest comme ARC

§  Authentification avec le mot de passe

§  Authentification avec le Refresh Token

o   Personnaliser le paramétrage des timeout des tokens

3.       Sécurité l’ensemble des micro-services fonctionnels en mode Bearer-Only en utilisant Spring Security et des adaptateurs Keycloak. On suppose que les micro-services ne sont accessigble que pour les utilisateurs authentifiésavec leurs rôles respectifs : PRODUCT_MANAGER, CUSTOMER_MANAGER et BILLING_MANAGER.

4.       Développer une application Web Front End qui permet de gérer les produits, les clients et les factures en utilisant le Framework de votre choix : Angulrar, React ou Spring MVC avec Thymeleaf.

5.       Sécuriser l’application FrontEnd en mode public client en mettant en place l’adaptateur Keycloak qui instaure un système d’authentification via Keycloak.

6.       Personnaliser la sécurité de la partie frontend en ajoutant les autres fonctionnalités fournies par Keycloak

·       Auto-inscription des utilisateurs

·       Politique des mots de passe

·       Double authentification OTP

·       Etc…

7.       Mise en place d’une solution de messagerie asynchrone avec le Broker KAFKA

a.       Mettre en place le Broker KAFKA

b.       Créer un micro-service Spring Boot qui permet de simuler un Producer KAFKA qui permet d’envoyer à un tompic « FACTURATION » à chaque seconde un message contenant le numéro de la facture, le nom du client et le montant de la facture.

c.       Créer un Micro-service Spring Boot qui permet de consommer les messages du Topic « FACTURATION » et de les enregistrer  dans sa propre base de données et dans un fichier CSV, avec Une API REST qui permet de consulter les factures.

d.       Créer un Micro-service de Real Time Data Analytics en mode Stream Processing utilisant KAFKA Streams qui permet de traiter en temps réel les messages du Topic « FACTURATION » en produisant  des statistiques comme  Le Total des factures reçus pour les 5 dernières secondes et le total des factures de chaque client.

8.       Proposer une solution d’intégration de du BROKER KAFKA dans votre application

9.       Mettre en place un micro-service de batch processing avec Spring Batch permettant de traiter les données du fichier CSV de facturation produit par l’application
