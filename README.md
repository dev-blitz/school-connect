# SchoolConnect

SchoolConnect is a comprehensive school management system built with Spring Data and Spring Boot. It provides a unified platform to manage students, teachers, courses, attendance, and academic records efficiently.

---

## Features

- Student enrollment and profile management  
- Teacher information and class assignments  
- Course creation and scheduling  
- Attendance tracking with reports  
- Academic performance and grade management  
- Role-based access control (Admin, Teacher, Student)  
- RESTful API endpoints for easy integration  

---

## Technologies Used

- Java 17  
- Spring Boot  
- Spring Data JPA & Hibernate  
- MySQL/PostgreSQL (configurable)  
- Maven/Gradle build tools  
- Lombok for reducing boilerplate code  

---

## Getting Started

### Prerequisites

- Java 17 or higher  
- Maven or Gradle  
- MySQL or PostgreSQL database setup  

### Installation

1. Clone the repository

   git clone https://github.com/dev-blitz/school-connect.git
   cd school-connect
   
3. Configure database connection in `src/main/resources/application.properties` or `application.yml`:
   
4. Access the API at http://localhost:8080

---

## Sample API Endpoints

| Endpoint          | Description                   |
| ----------------- | -----------------------------|
| `GET /students`   | List all students             |
| `POST /students`  | Add a new student             |
| `GET /teachers`   | List all teachers             |
| `POST /attendance`| Record attendance entry       |

For full API documentation, refer to Swagger/OpenAPI docs in the project.

---

## Contact

Abhinab Dutta Gupta — abhinab.duttagupta@gmail.com

Project GitHub: https://github.com/dev-blitz/school-connect.git
