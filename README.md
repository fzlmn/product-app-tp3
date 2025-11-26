# 🛒 Projet Web MVC Produits — Spring Boot, Spring Security, JPA & Thymeleaf
## 🎯 Objectif du Projet
Ce projet a pour objectif de développer une application web MVC complète permettant la gestion de produits (CRUD) avec :

- Spring Boot

- Spring MVC

- Spring Data JPA

- Spring Security

- Thymeleaf (avec Layout Dialect)

- H2 Database (mémoire)

- Bootstrap (WebJars)

Le projet met en œuvre plusieurs concepts essentiels :

- Architecture MVC

- Validation des formulaires

- Sécurité basée sur les rôles (USER / ADMIN)

- Gestion d’une base de données via JPA

- Pages web dynamiques avec Thymeleaf

## 📁 Structure du Projet
<img width="650" height="850" alt="image" src="https://github.com/user-attachments/assets/53555239-c8ab-4d69-ab41-39079ba69b33" />

<i>Figure 1 — Structure générale du projet<i>

## 1️⃣ Modèle — Entity & JPA
### 🧩 Classe Product (Entity JPA)
La classe Product représente la table des produits dans la base de données.

Elle utilise :

- JPA → mapping objet‑relation

- Lombok → pour réduire le code (getters, setters, builders…)

- Validation → contraintes sur les champs

Règles de validation :

- Nom : 3 à 50 caractères

- Prix ≥ 0

- Quantité ≥ 1

- ID généré automatiquement (IDENTITY)

### 📦 ProductRepo — Accès aux données
ProductRepo étend JpaRepository, ce qui fournit automatiquement :

- _findAll_

- _save_

- _delete_

- _findById_

Sans écrire la moindre requête SQL.


## 2️⃣ Sécurité — Spring Security
🔐 Configuration : SecurityConfig
La classe SecurityConfig gère toute la sécurité de l’application.

Fonctionnalités :

Deux utilisateurs en mémoire (ADMIN, USER)

Mots de passe cryptés (BCrypt)

Page de login personnalisée

Gestion des accès selon les rôles

Méthodes protégées avec @PreAuthorize

Pages publiques : /public/** et /webjars/**


## 3️⃣ Web Layer — Controllers MVC
### 📊 ProductController
Ce contrôleur gère toutes les pages liées aux produits :

Liste des produits

Ajout d’un produit

Suppression

Validation des formulaires

Redirections

Protection des méthodes selon les rôles

Sécurité :

/user/** → role USER

/admin/** → role ADMIN


## 4️⃣ Application — Spring Boot
### 🚀 Classe Principale
La classe main démarre l’application.

Un CommandLineRunner insère quelques produits de démonstration au démarrage.


## 5️⃣ Vues — Thymeleaf + Layout Dialect
### 🧱 layout1.html (Template principal)
Contient :

Navbar Bootstrap

Affichage du nom de l’utilisateur connecté

Sections visibles selon le rôle (ADMIN seulement pour “Add Product”)

Zone content1 où les autres pages s’insèrent


### 🔑 login.html — Page de connexion
Formulaire personnalisé pour Spring Security :

username / password obligatoires

POST vers /login

Design Bootstrap

(Insérer capture du login)
Figure 8 — Page de login

### ➕ addProduct.html — Ajout d’un produit
Utilise le layout dialect

Affiche les erreurs de validation

Champs préremplis en cas d’erreur

Envoi vers /admin/saveProduct

(Insérer capture de la page)
Figure 9 — Formulaire d’ajout

### 📄 productsList.html — Liste des produits
Affiche tous les produits envoyés par le contrôleur

Bouton Delete visible uniquement pour ADMIN

Bouton New Product uniquement pour ADMIN

Boucle Thymeleaf : th:each="p : ${productsList}"

(Insérer capture de la liste)
Figure 10 — Liste des produits

⚠ unauthorized.html — Page d’accès refusé
Affichée lorsque l’utilisateur tente d’accéder à une page interdite selon son rôle.

(Insérer capture)
Figure 11 — Page Unauthorized

## 6️⃣ Configuration — application.properties
### 💾 Configuration de la base H2
Base en mémoire : jdbc:h2:mem:products-db

username = sa

H2 Console activée : /h2-console

⚙ Hibernate
spring.jpa.hibernate.ddl-auto=update
→ création automatique des tables.

### 🌐 Port HTTP
L’application tourne sur 8085.

(Insérer capture du fichier properties)
Figure 12 — Configuration du projet

## ✔️ Conclusion
Ce projet met en pratique l’ensemble des mécanismes essentiels d’une application Spring Boot professionnelle :

MVC

Sécurité basée sur rôles

JPA & Repositories

Thymeleaf + Layout dialect

Base H2

Validation des formulaires

Il constitue une base solide pour n’importe quel futur projet web utilisant le même stack.
