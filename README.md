# 🎓 Student Management System

![Java](https://img.shields.io/badge/Java-17-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen?logo=springboot)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)
![Build](https://img.shields.io/badge/Build-Maven-yellow?logo=apache-maven)
![Database](https://img.shields.io/badge/Database-MySQL-lightblue?logo=mysql)

A **Spring Boot-based web application** that provides **separate portals for Admin and Students**.  
Admins can manage student records (CRUD), while Students can log in to view their profiles, academic data, and courses.  

---

## 🚀 Features

### 🔑 Admin Portal
- Admin authentication & role-based access  
- CRUD operations for students (Add, Update, Delete, List)  
- Dashboard with student analytics  
- Responsive UI with **Thymeleaf + Tailwind CSS + Bootstrap**  

### 👩‍🎓 Student Portal
- Student login with secure authentication  
- Personal dashboard showing student details  
- View courses, grades, and academic progress  
- Update personal profile  

---

## 🛠️ Technology Stack
- **Backend**: Spring Boot 3.x, Spring Security, Spring Data JPA  
- **Frontend**: Thymeleaf, Tailwind CSS, Bootstrap  
- **Database**: MySQL / PostgreSQL / H2 (development)  
- **Authentication**: JWT / Session-based (configurable), BCrypt Password Encoding  
- **Build Tool**: Maven  

---

## 📦 Installation & Setup

### ✅ Prerequisites
- Java 17+  
- Maven 3.6+  
- MySQL 5.7+ or PostgreSQL  

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/StudentManagementSystem.git
cd StudentManagementSystem
