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



<h1>Sécurité des systèmes distribués avec Keycloak</h1>

<h5>Mettre en place le serveur d’authentification OAuth2 Keycloak version 12.0.1</h5>
la mise en place de la dernier version de Keycloak 18.0.0

![image](https://user-images.githubusercontent.com/84507906/175132001-28e8f203-6590-4800-b48b-c162fb69b929.png)

Le lancement de Kaycloak avec standalone.bat

![image](https://user-images.githubusercontent.com/84507906/175132102-e6026181-a209-4f73-a4c1-181d8d072644.png)

<h5> Créer un Realm</h5>

La creation du Realm "BillingRealm"

![Realm](https://user-images.githubusercontent.com/84507906/175132211-bbbace66-2906-4818-be51-ef3912782a15.PNG)

<h5>Le client à sécuriser en mode public client</h5>

La creation d'un client msProjet

![ClientPage_msProjet](https://user-images.githubusercontent.com/84507906/175132407-7411aef5-30a3-4948-8521-a8e836190091.PNG)

<h5>Créer les rôles (USER, ADMIN, PRODUCT_MANAGER, CUSTOMER_MANAGER et BILLING_MANAGER)</h5>

![RolesListe](https://user-images.githubusercontent.com/84507906/175132506-41a2cae5-c630-4088-8359-cda2e87457bd.PNG)

<h5> Créer quelques utilisateurs</h5>

![UsersListe](https://user-images.githubusercontent.com/84507906/175132631-f8417781-4b16-49c9-bf4f-3cf06c3b324d.PNG)

<h5>Affecter les rôles aux utilisateurs</h5>

Affectation des roles au user ayoub

![UsersRols](https://user-images.githubusercontent.com/84507906/175132698-e96e40f9-0822-4f25-8fbe-845962927944.PNG)

<h5>Authentification avec le mot de passe</h5>

![LoginPage](https://user-images.githubusercontent.com/84507906/175132956-e684f067-cfad-4058-bc3e-cd8d91891c62.PNG)

<h1>Sécurité l’ensemble des micro-services fonctionnels en mode Bearer-Only en utilisant Spring Security et des adaptateurs Keycloak. On suppose que les micro-services ne sont accessigble que pour les utilisateurs authentifiésavec leurs rôles respectifs : PRODUCT_MANAGER, CUSTOMER_MANAGER et BILLING_MANAGER.</h1>

La commande keycloak.bearer-only= true pour securisé les microSerices 

<h1>Front end</h1>
  La partie front end avec Spring MVC
  
  La page index
  
  ![indexPage](https://user-images.githubusercontent.com/84507906/175133458-29b4d760-10fa-4c8e-bd3d-bb5b596292d0.PNG)
  
  La page de login avec Keycloak
  
  ![LoginPage](https://user-images.githubusercontent.com/84507906/175133501-4623f966-8d8e-4b8b-827f-286441be34a5.PNG)
   
  La page des clients
  
  ![LaListeDesClients](https://user-images.githubusercontent.com/84507906/175133563-0d8324bf-1151-4f96-b0c1-2fb2f2aac265.PNG)
  
  La liste des produits
  
  ![ListeDesProduits](https://user-images.githubusercontent.com/84507906/175133625-84283eec-545f-4a8e-b864-ad757b2a8ad3.PNG)
  
  

<h1>Mise en place d’une solution de messagerie asynchrone avec le Broker KAFKA</h1>

Les données generer par le pooler sont stocker dans un fichier .csv

![FacturationCSV](https://user-images.githubusercontent.com/84507906/175133846-dc291208-0242-46b3-ab32-528f12b5b4b6.PNG)

et aussi dans la base de données

![DonnéesStockerBDD](https://user-images.githubusercontent.com/84507906/175133949-41a359b8-3430-4e02-9027-23598d53719a.PNG)

![DataReturnStoreCSV_BDD](https://user-images.githubusercontent.com/84507906/175133996-59646e54-9273-4bb3-b8bf-e0c516e7322d.PNG)

La table facturation

![TableFacturation](https://user-images.githubusercontent.com/84507906/175134029-0fb3914b-6a6d-44fd-8fb1-73fcfedfe592.PNG)
