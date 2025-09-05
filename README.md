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
