# 📰 Aulab Chronicle

> An online news platform with quality fact-checking and multi-role content management system

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-23-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Database Setup](#database-setup)
  - [Configuration](#configuration)
- [User Roles](#user-roles)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [Acknowledgments](#acknowledgments)

---

## 🎯 About the Project

**Aulab Chronicle** is an online news platform developed as the final project during the intensive Java and Backend specialization bootcamp at [Aulab](https://aulab.it/). 

The platform enables users to view countless news articles with a quality fact-checking system, featuring a comprehensive content management workflow with multiple user roles and approval processes.

This project demonstrates advanced Java/Spring Boot development skills including:
- Multi-role authentication and authorization
- Complex entity relationships
- File upload and image manipulation
- Full-text search implementation
- Email notifications
- RESTful API design

---

## ✨ Features

### Core Functionality

#### 📝 Article Management
- **Create Articles**: Logged-in users can submit new articles
- **Article Components**:
  - Title
  - Subtitle
  - Body text
  - Category assignment
  - Image upload (via Supabase)
- **Public Viewing**: Anyone can view published articles and their details
- **Recent Articles**: Homepage displays the most recent articles
- **Article Sorting**: Articles ordered from newest to oldest

#### 🔍 Search & Filtering
- **Full-text Search** across:
  - Article titles
  - Subtitles
  - Categories
- **Filter by Category**: Click-based category filtering
- **Filter by Author**: Search articles by writer

#### 👥 User System
- **Registration & Login**: Secure user authentication
- **Career Requests**: Users can apply to join the team via "Work with Us" form
- **Role-based Access Control**: Different dashboards and permissions per role

#### ⚙️ Administrative Features
- **Article Approval System**: Designated users can approve/reject articles
- **Category Management**: Admin-only creation, modification, and deletion
- **Request Management**: Admin dashboard to handle career requests
- **Article Modification**: Writers can edit their own articles
- **Article Deletion**: Writers can delete their own articles

#### 🔄 Advanced Features
- **Re-review on Edit**: Modified articles return to the review queue
- **Email Notifications**: Automated notifications for various actions
- **Image Manipulation**: Integration with Supabase for image storage and processing
- **Real-time Updates**: Notification interceptor for user feedback

---

## 🛠️ Tech Stack

### Backend
- **Framework**: Spring Boot 3.3.4
- **Language**: Java 23
- **Security**: Spring Security 6
- **ORM**: Spring Data JPA / Hibernate
- **Validation**: Spring Validation
- **Database**: MySQL 8.0+
- **Build Tool**: Maven

### Frontend
- **Template Engine**: Thymeleaf
- **CSS Framework**: Bootstrap (implied from templates)
- **Integration**: Thymeleaf Spring Security extras

### Additional Technologies
- **Image Storage**: Supabase
- **Email Service**: Mailtrap (SMTP)
- **Object Mapping**: ModelMapper
- **Development**: Spring DevTools, Lombok

---

## 🚀 Getting Started

### Prerequisites

Before running this project, ensure you have the following installed:

- **Java JDK 23** or higher
- **Maven 3.8+**
- **MySQL 8.0+**
- **Git**

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Hackademy-Specializzazione-Java/Progetto_Finale_Java_Alberto_Comerci.git
   cd progetto_finale_java
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```
   
   On Windows:
   ```bash
   mvnw.cmd clean install
   ```

### Database Setup

1. **Create the database**
   ```sql
   CREATE DATABASE progettofinalejava;
   ```

2. **Run the SQL scripts** (in order)
   ```bash
   mysql -u root -p progettofinalejava < sql/create.sql
   mysql -u root -p progettofinalejava < sql/insert.sql
   mysql -u root -p progettofinalejava < sql/createImageTable.sql
   mysql -u root -p progettofinalejava < sql/alterTableArticle.sql
   mysql -u root -p progettofinalejava < sql/createCareerRequest.sql
   mysql -u root -p progettofinalejava < sql/changeUserRole.sql
   ```

### Configuration

1. **Update `application.properties`**

   Configure your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/progettofinalejava
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

2. **Configure Supabase** (for image storage)
   
   Update with your Supabase credentials:
   ```properties
   supabase.url=your_supabase_url
   supabase.key=your_supabase_key
   supabase.bucket=/storage/v1/object/your_bucket/
   supabase.image=/storage/v1/object/public/your_bucket/
   ```

3. **Configure Email Service**
   
   Update SMTP settings (Mailtrap or your provider):
   ```properties
   spring.mail.host=your_smtp_host
   spring.mail.port=your_smtp_port
   spring.mail.username=your_smtp_username
   spring.mail.password=your_smtp_password
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   
   Or on Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```

5. **Access the application**
   
   Open your browser and navigate to:
   ```
   http://localhost:8080
   ```

---

## 👤 User Roles

The platform implements a hierarchical role-based access control system:

### 🌐 Guest (Unauthenticated User)
- View published articles
- Browse by category
- Search articles
- View article details

### ✍️ Writer
- All Guest permissions
- Create new articles
- Access Writer Dashboard
- Edit their own articles
- Delete their own articles
- Submit articles for review

### 🔍 Revisor
- All Guest permissions
- Access Revisor Dashboard
- View articles pending review
- Approve articles
- Reject articles
- Review modified articles

### 👑 Admin
- All Revisor permissions
- Access Admin Dashboard
- Create, modify, and delete categories
- Manage career requests
- Approve/reject team membership applications
- Full platform control

---

## 📁 Project Structure

```
progetto_finale_java/
├── src/
│   ├── main/
│   │   ├── java/it/aulab/progetto_finale_java/
│   │   │   ├── config/              # Security, Web, and Interceptor configs
│   │   │   ├── controllers/         # REST and MVC controllers
│   │   │   ├── dtos/                # Data Transfer Objects
│   │   │   ├── models/              # JPA Entity classes
│   │   │   ├── repositories/        # Spring Data JPA repositories
│   │   │   ├── services/            # Business logic layer
│   │   │   ├── utils/               # Utility classes
│   │   │   └── ProgettoFinaleJavaApplication.java
│   │   └── resources/
│   │       ├── application.properties  # Application configuration
│   │       ├── static/images/       # Static image resources
│   │       └── templates/           # Thymeleaf templates
│   │           ├── admin/           # Admin dashboard views
│   │           ├── article/         # Article CRUD views
│   │           ├── auth/            # Login/Register views
│   │           ├── career/          # Career request views
│   │           ├── category/        # Category management views
│   │           ├── revisor/         # Revisor dashboard views
│   │           └── writer/          # Writer dashboard views
│   └── test/                        # Unit and integration tests
├── sql/                             # Database schema and migration scripts
├── pom.xml                          # Maven dependencies
└── README.md
```

---

## 💡 Usage

### For Writers

1. **Register an account** at `/register`
2. **Request Writer role** via the "Work with Us" form
3. **Wait for Admin approval**
4. Once approved, **create articles** from your dashboard
5. **Submit for review**
6. **Edit or delete** your articles as needed

### For Revisors

1. **Login** with Revisor credentials
2. **Access Revisor Dashboard**
3. **Review pending articles**
4. **Approve or reject** based on quality standards
5. **Provide feedback** if rejecting

### For Admins

1. **Login** with Admin credentials
2. **Manage categories** (create, update, delete)
3. **Review career requests** and promote users
4. **Monitor platform activity**
5. **Oversee content quality**

---

## 🔌 API Endpoints

### Authentication
- `GET /login` - Login page
- `POST /login` - Authenticate user
- `GET /register` - Registration page
- `POST /register` - Create new account

### Articles
- `GET /` - Home page (public articles)
- `GET /articles` - All published articles
- `GET /article/{id}` - Article detail
- `GET /article/create` - Create article form (authenticated)
- `POST /article/create` - Submit new article
- `GET /article/edit/{id}` - Edit article form (writer only)
- `POST /article/edit/{id}` - Update article
- `DELETE /article/delete/{id}` - Delete article (writer only)

### Categories
- `GET /category/{id}` - Articles by category
- `GET /category/create` - Create category (admin only)
- `POST /category/create` - Submit new category
- `GET /category/update/{id}` - Update category (admin only)
- `DELETE /category/delete/{id}` - Delete category (admin only)

### Dashboards
- `GET /writer/dashboard` - Writer dashboard
- `GET /revisor/dashboard` - Revisor dashboard
- `GET /admin/dashboard` - Admin dashboard

### Career Requests
- `GET /career/request` - Career request form
- `POST /career/request` - Submit career request
- `GET /career/request/{id}` - Request detail (admin only)

---

## 🏗️ Database Schema

### Key Entities

- **User**: User accounts with roles (Writer, Revisor, Admin)
- **Article**: News articles with title, subtitle, body, and images
- **Category**: Article categorization (1-to-Many with Articles)
- **CareerRequest**: Job applications for team membership
- **Image**: Image metadata linked to articles

### Relationships

- `User → Article`: One-to-Many (author relationship)
- `Category → Article`: One-to-Many
- `Article → Image`: One-to-Many
- `User → CareerRequest`: One-to-Many

---

## 🤝 Contributing

This is a final bootcamp project and is not actively maintained. However, feel free to:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 🎓 Acknowledgments

- **[Aulab](https://aulab.it/)** - For the intensive Java and Backend specialization bootcamp
- **Spring Boot Community** - For excellent documentation and support
- **All instructors and classmates** - For guidance and collaboration throughout the bootcamp

---

## 👨‍💻 Author

**Alberto Comerci**

- GitHub: [@Hackademy-Specializzazione-Java](https://github.com/Hackademy-Specializzazione-Java)
- Project: [Progetto_Finale_Java_Alberto_Comerci](https://github.com/Hackademy-Specializzazione-Java/Progetto_Finale_Java_Alberto_Comerci)

---

## 📄 License

This project is part of an educational bootcamp and is available for educational purposes.

---

<div align="center">

**Built with ❤️ during Aulab's Java Bootcamp 2024**

</div>
