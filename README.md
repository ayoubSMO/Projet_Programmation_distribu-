# Projet_Programmation_distribu-
This repository is for showing how this project works.

# Youssfi-Project
this repository is for collabing.

L’objectif est de créer un système distribué basé sur les micro-services permettant de gérer les factures des clients en utilisant la même architecture que vous avez déjà développé auparavant en y intégrant un système de sécurité basé sur Keycloak, Un Bus de messagerie avec KAFKA, un service de Stream processing avec Kafka Streams et un service de Batch Processing avec Spring Batch.

![image (1)](https://user-images.githubusercontent.com/84507906/172048467-bdd777a0-0aa4-4a00-b352-ce87e87a274e.png)



A la fin, nous projetons appliquer pour cette application les patterns CQRS et Event Sourcing.

Ressources à utiliser :

Architecture Micro-services :

·       Part 1 : https://www.youtube.com/watch?v=u8awF6FCR8Q

·       Part 2 : https://www.youtube.com/watch?v=d5qoT6cW1i0

·       Part 3 : https://www.youtube.com/watch?v=Ufdd45-H6uA

·       Part 4 : https://www.youtube.com/watch?v=IhNxrE5tlXs

·       Part 5 : https://www.youtube.com/watch?v=2p8wdKHx5jo

·       Part 6 : https://www.youtube.com/watch?v=jGvkVGCUf-w

Sécurité des systèmes distribués avec Keycloak

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
