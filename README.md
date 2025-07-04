# 🥗 RecipeVerse – API de partage de recettes avec IA (Spring Boot)

RecipeVerse est une API REST construite avec **Spring Boot**, **Spring Security**, **JWT**, **JPA**, **Swagger**, et **Mistral AI**, permettant à des utilisateurs de partager, commenter, noter et générer des recettes automatiquement à l’aide de l’intelligence artificielle.

---

## 🚀 Fonctionnalités

- 🔐 Authentification & rôles (`USER`, `ADMIN`) avec JWT
- 📚 Gestion complète des recettes
- 🍽️ Ingrédients liés aux recettes
- 🗂️ Catégories personnalisées par un admin
- ⭐ Notation avec moyenne automatique
- 💬 Commentaires sur chaque recette
- 🧠 Suggestions de recettes IA via [Mistral AI](https://mistral.ai)
- 🧾 Documentation Swagger auto-générée
- 📬 Collection Postman incluse

---

## 🛠️ Tech Stack

- Spring Boot 3.x  
- Spring Security (JWT)  
- Spring Data JPA + PostgreSQL  
- Swagger / OpenAPI  
- Lombok  
- Mistral AI API  
- Déploiement : Railway / Render

---

## 📂 Architecture

```text
com.sparkle.recipeverse
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
├── config
