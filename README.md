# rdv_medic

Projet Angular + Spring Boot : Gestion de rendez-vous médicaux

Objectif
Développer une application web permettant aux patients de prendre des rendez-vous avec des médecins via une interface simple.
Le système doit gérer les médecins, leurs créneaux horaires disponibles, les patients et les réservations de rendez-vous.
Utilisateurs et rôles
Patient :
Voir la liste des médecins
Voir les créneaux disponibles
Réserver un créneau
Consulter ses rendez-vous
Médecin :
Ajouter ou supprimer des créneaux
Voir les rendez-vous réservés
Architecture
Frontend : Angular
Backend : Java Spring Boot
Base de données : H2 
Workflow de réservation
1. Le patient consulte la liste des médecins.
2. Il sélectionne un médecin et voit ses créneaux disponibles.
3. Il choisit un créneau et remplit un formulaire.
4. Le backend vérifie la disponibilité, crée le rendez-vous et marque le créneau comme réservé.










Objectif de l'exercice
 Le but de ce projet est de t’accompagner progressivement dans la mise en place d’une application complète. Voici les étapes à suivre :
 
Étude des besoins
Commence par analyser le besoin fonctionnel. Essaie d’identifier les différents cas d’usage.
 
Modélisation
Rédaction d’un diagramme de classes représentant les entités métier.
Préparation d’un ou plusieurs diagrammes de séquence pour illustrer les interactions entre les composants dans les différents cas d’usage.
 
Développement Back-end (Java + Spring Boot)
Faire une autoformation rapide sur spring boot : https://openclassrooms.com/fr/courses/6900101-creez-une-application-java-avec-spring-boot#table-of-content
Création des entités Java.
Création des tables SQL correspondantes.
Implémentation des services pour faire le lien entre la base de données et ton application.
 
Découverte et développement Front-end (Angular)
Faire une autoformation rapide sur Angular (https://openclassrooms.com/en/courses/7471261-debutez-avec-angular#table-of-content).
Développement de la partie front de ton application.
Mise en place de la connexion entre le front-end Angular et le back-end Spring Boot.

API REST
GET /api/medecins → Liste des médecins
GET /api/medecins/{id}/creneaux → Créneaux d’un médecin
POST /api/medecins/{id}/creneaux → Ajouter un créneau
DELETE /api/creneaux/{id} → Supprimer un créneau
POST /api/rendezvous → Réserver un créneau
GET /api/patients/{id}/rendezvous → Liste des RDV d’un patient

Interfaces Angular
- medecin-list.component.ts : liste des médecins
- creneau-list.component.ts : créneaux disponibles
- reservation-form.component.ts : formulaire réservation
- patient-rendezvous.component.ts : liste des RDV d’un patient
Améliorations possibles
- Authentification avec JWT
- Design avec Angular Material ou bootsrap
- Validation et gestion des erreurs
Tests avec Postman    plant text
plantuml
visualparadigm


Spring Boot œuvre pour la simplification du développement de nos projets avec Spring Framework.
La gestion des dépendances est simplifiée grâce aux starters qui regroupent plusieurs dépendances et homogénéisent les versions.
L’autoconfiguration permet de se concentrer sur le code métier, et simplifie énormément la mise en œuvre des composants Spring qui sont utilisés.
La gestion efficace des propriétés rend notre application configurable.
Spring Boot Actuator permet de monitorer et gérer une application pendant son exécution.
Le déploiement de l’application est facilité par la génération d’un JAR, et pour les projets web, un tomcat est embarqué.

couche Controller : gestion des interactions entre l’utilisateur de l’application et l’application ;
couche Service : implémentation des traitements métiers spécifiques à l’application ;
couche Repository : interaction avec les sources de données externes ;
couche Model : implémentation des objets métiers qui seront manipulés par les autres couches.










Architectures des couches springboot












Architechture des composants logiciels










 
Pour implémenter une API qui communique avec une base de données, 3 éléments sont essentiels :
Le starter web qui permettra d’exposer les endpoints.
Un starter pour gérer la persistance des données (comme Spring Data JPA).
La dépendance pour le driver de la base de données concernée (par ex. H2 Database ou MySQL Driver).

Récapitulatif des couches projet spring boot ; 



Annotation a mettre dans controller


1. Model (ou Entity Layer)
👉 Quoi ? Ce sont tes classes qui représentent les données du domaine (les objets métier). Exemple : Doctor, Patient, Slot, etc.
👉 Rôle :
Définir la structure des données (les attributs, types, contraintes).
Être reliées à la base via JPA/Hibernate avec les annotations (@Entity, @Table, @Id, etc.).
👉 Avantage : Tu manipules directement des objets Java au lieu d’écrire tout le temps des requêtes SQL.

2. Repository (ou DAO Layer)
👉 Quoi ? C’est l’interface entre la base de données et ton application. Exemple : DoctorRepository, PatientRepository.
👉 Rôle :
Accéder aux données avec CRUD (Create, Read, Update, Delete).
Spring Data JPA génère automatiquement beaucoup de méthodes (findById, findAll, save, etc.).
Permet de créer des requêtes personnalisées avec des noms de méthode (findByNom) ou avec @Query.
👉 Avantage : Tu n’as presque pas besoin d’écrire du SQL → Spring s’en charge.

3. Service (ou Business Layer)
👉 Quoi ? C’est la couche qui contient la logique métier (les règles de ton application). Exemple : DoctorService, PatientService.
👉 Rôle :
Centraliser les règles métier (ex : "un patient ne peut pas réserver 2 créneaux en même temps").
Faire appel aux repositories pour interagir avec la base.
Fournir des méthodes réutilisables par les controllers.
👉 Avantage : Évite de mettre la logique directement dans les controllers. Tu gardes tes controllers propres (juste REST) et ta logique métier bien organisée.

4. Controller (ou Web Layer)
👉 Quoi ? C’est l’interface entre ton API et l’extérieur. Exemple : DoctorController, PatientController.
👉 Rôle :
Exposer des endpoints REST (/doctors, /patients, /slots).
Recevoir les requêtes HTTP (GET, POST, PUT, DELETE).
Appeler le service approprié.
Retourner une réponse JSON (ou autre format).
👉 Avantage : Tu sépares la logique web (API REST) de la logique métier (Service).

5. (Optionnel) DTO Layer
👉 Quoi ? Ce sont des objets "de transport de données" (DoctorDTO, PatientDTO). Ils servent à exposer ou recevoir des données différentes de celles de tes entités.
👉 Exemple : Si tu veux retourner seulement nom et spécialité d’un médecin, sans envoyer tous ses champs.
👉 Avantage :
Sécurité (ne pas exposer toutes les infos).
Flexibilité (tu peux transformer tes entités en un format adapté aux besoins du front).

Résumé visuel 🔗

[ Controller ]  <-- (API REST : reçoit la requête HTTP, appelle le service)
      |
[ Service ]     <-- (Logique métier : règles, validations, orchestration)
      |
[ Repository ]  <-- (Accès base de données : CRUD, requêtes SQL via JPA)
      |
[ Model ]       <-- (Entités : représentation des données en objets Java)

👉 En gros :
Model = structure des données
Repository = accès DB
Service = logique métier
Controller = exposition API

Utiliser " ResponseEntity <ContractsResponse>" pour accéder a une réponse http pour savoir si il reçoit bien l’information lors du test de l’api etc. avec un " return new ResponseEntity < >(…,HttpStatus.OK).  Voir également JpaRepository 
Les deux (CrudRepository et JpaRepository) viennent de Spring Data JPA et servent à interagir avec la base sans écrire de requêtes SQL manuelles.

CrudRepository<T, ID>
Objectif : fournir les opérations CRUD de base
save()
findById()
findAll()
deleteById()
C’est l’interface la plus simple, légère.
Elle est adaptée quand tu veux juste faire du CRUD simple, sans fonctionnalités avancées.
✅ Avantages :
Très simple, clair.
Suffisant si tu veux juste lire/écrire/supprimer des données.
❌ Limites :
Pas de méthodes pour la pagination, tri ou certaines opérations plus avancées.

🔹 JpaRepository<T, ID>
C’est une sous-interface de PagingAndSortingRepository, qui elle-même hérite de CrudRepository.
Donc JpaRepository inclut tout ce que CrudRepository fait, mais en plus :
findAll(Sort sort) → permet de trier facilement.
findAll(Pageable pageable) → pagination.
flush() → force l’écriture immédiate en base.
saveAndFlush() → sauvegarde et flush en même temps.
deleteInBatch() → suppression en lot.
✅ Avantages :
Plus complet, idéal si tu veux de la pagination, du tri, ou des opérations un peu plus poussées.
❌ Limites :
Un peu plus riche (tu peux être tenté d’utiliser des méthodes dont tu n’as pas besoin).
Si ton projet est très simple, CrudRepository est déjà suffisant.



