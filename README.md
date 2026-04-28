PROJECT DESCRIPTION

This project is a backend application for a simple e-commerce system built using Spring Boot. 
It provides REST APIs for user authentication, product management, and order processing.
The application allows users to register and log in, browse and search products, place orders,
and manage product data including images.

FEATURES

Authentication
User registration and login
JWT token generation for authenticated users

Product Management
Create, update, delete products
Retrieve all products or a single product by ID
Upload and store product images
Search products by keyword

Order Management
Place new orders
Retrieve all orders
Store order items with quantity and total price

TECHNOLOGIES USED

Java
Spring Boot
Spring Web
Spring Data JPA
Spring Security
JWT (JSON Web Token)
Hibernate
Lombok
Relational Database (e.g. MySQL or H2)

PROJECT STRUCTURE

Controller layer
Handles HTTP requests and exposes REST endpoints for authentication, products, and orders.

Service layer
Contains business logic for authentication, product handling, and order processing.

Repository layer
Handles database operations using Spring Data JPA.

Model layer
Contains entity classes such as Product, Order, OrderItem, and User.

DTO layer
Used for request and response objects to separate API contracts from internal models.

Security
Basic JWT utility for token generation and extraction. Security configuration is currently minimal.

API ENDPOINTS

Authentication

POST /api/auth/register
POST /api/auth/login

Products

GET /api/products
GET /api/product/{id}
GET /api/product/{id}/image
POST /api/product
PUT /api/product/{id}
DELETE /api/product/{id}
GET /api/products/search?keyword=

Orders

POST /api/orders/place
GET /api/orders

NOTES

Product images are stored in the database as byte arrays.
JWT is generated but not fully enforced in security configuration.
CORS is enabled for all controllers.

FUTURE IMPROVEMENTS

Implement full JWT authentication and authorization
Add role-based access control (ADMIN/USER)
Add validation and error handling
Add pagination for product listing
Improve security configuration
Add unit and integration tests
