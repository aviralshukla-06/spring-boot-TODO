# 📝 Spring Boot + MySQL Todo App

A highly dynamic **Todo Application** built using **Spring Boot**, **MySQL**, and **React**, with full authentication and authorization using **JWT**, **Spring Security**, and **BCrypt**.  
This app allows multiple users to manage their todos seamlessly, with role-based access control for **Admin** and **User** roles.

---

## 🚀 Tech Stack

### Backend
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **BCrypt** for password encryption
- **MySQL Database**

### Frontend
- **ReactJS**
- **Axios** for API communication
- **TypeScript / JavaScript** (based on your frontend setup)
- **link** : https://github.com/aviralshukla-06/spring-todo-frontend

---

## 📁 Project Structure

<img width="480" height="417" alt="image" src="https://github.com/user-attachments/assets/d0740ef6-3813-48b3-8012-fd1b9fea1089" />



---

## ⚙️ Setup Instructions

### 🧩 Backend Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/springboot-todo.git
   cd springboot-todo

2. **Database Setup**
   -Go to MySQL and create database named ##springdb_todo

3. **application.properties setup**
   spring.application.name=myFirstDocumentation

      spring.datasource.url=jdbc:your_mysql_connection_string
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
      
      server.port=8080
      
      # JWT
      jwt.secret=Setup_yout-32bit_secret
      jwt.expiration-ms=3600000 
      
      # CORS - optional: frontend origin
      app.cors.allowed-origins=http://localhost:5173

4. **Run application foll. cmd**
   ```bash
   mvn spring-boot:run

5. **Test with postman for follow instructions for frontend setup***

      #Frontend setup
1. Make sure to have:
   React
   Typescript
   Node
   
- copy command
  ```bash
  git clone https://github.com/aviralshukla-06/spring-todo-frontend.git
- run foll.
  ```bash
  npm run dev


