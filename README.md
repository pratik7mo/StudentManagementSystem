Student Management System - Documentation
📌 Introduction
The Student Management System is a Spring Boot-based web application designed to manage student information with separate Admin and Student portals. It provides secure authentication, student CRUD operations, academic records management, and dashboards for both administrators and students.
🚀 Features
Admin Portal
• Secure login authentication
• Full CRUD operations for students
• Dashboard with statistics and charts
• Responsive UI with Tailwind CSS
Student Portal
• Secure login
• Personal dashboard & profile view
• Access to courses, grades, and academic records
🛠️ Technology Stack
• Backend: Spring Boot 3.x, Spring Security, Spring Data JPA
• Frontend: Thymeleaf, Tailwind CSS, Bootstrap
• Database: MySQL / PostgreSQL / H2
• Security: BCrypt password encryption, Role-based authentication
• Build Tool: Maven
📦 Installation & Setup
1. Clone the Repository:
   git clone https://github.com/your-username/StudentManagementSystem.git
   cd StudentManagementSystem

2. Configure Database in application.properties

3. Build and Run:
   mvn clean install
   mvn spring-boot:run

4. Access the Application:
   Main: http://localhost:8080
   Admin Login: http://localhost:8080/admin-login
   Student Login: http://localhost:8080/student-login
   H2 Console: http://localhost:8080/h2-console
👥 User Roles
Administrator:
• Manage all student records
• View analytics and reports
• Add, edit, delete student information

Student:
• View personal profile & grades
• Access academic records
• Update contact information
🔐 Security Features
• Password encryption with BCrypt
• Role-based access control
• CSRF protection
• Secure session management
• Separate authentication for admin & students
📁 Project Structure
src/
 ├── main/java/com/develop/sms/
 │   ├── controller/   # MVC Controllers
 │   ├── entity/       # JPA Entities
 │   ├── repository/   # Repositories
 │   ├── service/      # Service Interfaces
 │   ├── serviceImpl/  # Implementations
 │   └── config/       # Security & Config
 └── resources/
     ├── templates/    # Thymeleaf Templates
     ├── static/       # CSS, JS, Images
     └── application.properties
🤝 Contributing
1. Fork the repository
2. Create a feature branch: git checkout -b feature-name
3. Commit changes: git commit -m 'Add feature'
4. Push: git push origin feature-name
5. Submit a pull request
📝 License
This project is licensed under the MIT License - see the LICENSE file for details.
