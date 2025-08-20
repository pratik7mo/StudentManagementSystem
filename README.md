🎓 Student Management System

A comprehensive Spring Boot-based web application for managing student information with separate Admin and Student portals.

🚀 Features
👨‍💼 Admin Portal

Secure login authentication

Full CRUD operations for students

Dashboard with statistics & charts

Responsive UI with Tailwind CSS

🎓 Student Portal

Secure student login

Personal dashboard & profile view

Access to courses, grades & academic records

🛠️ Tech Stack

Backend: Spring Boot 3.x, Spring Security, Spring Data JPA

Frontend: Thymeleaf, Tailwind CSS, Bootstrap

Database: MySQL / PostgreSQL / H2

Security: BCrypt password encryption, Role-based auth

Build Tool: Maven

📦 Installation
# Clone the repo
git clone https://github.com/your-username/StudentManagementSystem.git
cd StudentManagementSystem

# Build the project
mvn clean install

# Run the app
mvn spring-boot:run

🌐 Access

Main App → http://localhost:8080

Admin Login → http://localhost:8080/admin-login

Student Login → http://localhost:8080/student-login

H2 Console → http://localhost:8080/h2-console

👥 User Roles

Admin

Manage student records

View analytics & reports

Student

View profile & grades

Access courses

🔐 Security

BCrypt password encryption

Role-based access control

CSRF protection

Secure session management

📁 Project Structure
src/
 ├── main/java/com/develop/sms/
 │   ├── controller/   # MVC Controllers
 │   ├── entity/       # JPA Entities
 │   ├── repository/   # Repositories
 │   ├── service/      # Service Interfaces
 │   ├── serviceImpl/  # Service Implementations
 │   └── config/       # Security & Config
 └── resources/
     ├── templates/    # Thymeleaf Templates
     ├── static/       # CSS, JS, Images
     └── application.properties

🤝 Contributing

Fork repo

Create branch → git checkout -b feature-name

Commit changes → git commit -m 'Added feature'

Push → git push origin feature-name

Submit PR

📝 License

MIT License – see LICENSE
.
