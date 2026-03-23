# Full Stack Authentication Project (React + Spring Boot)

## 🚀 Project Overview
This is a full-stack web application built using **React (Frontend)** and **Spring Boot (Backend)**.  
The project demonstrates **JWT-based authentication** and **role-based access control (RBAC)**.

as the project document mentioned to use typescript but i have not worked or learned typescript and thats why used javascript in frontend
so please consider that
i will learn typescript if u give me opportunity

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- MySQL
- JPA / Hibernate

### Frontend
- React (Vite)
- JavaScript
- Tailwind CSS
- Axios
- React Router
- React Hot Toast

---

## 🔐 Features

- User Registration & Login
- JWT Authentication
- Role-Based Access (USER / ADMIN)
- Protected APIs
- Secure Password Storage (BCrypt)
- User Dashboard
- Admin Dashboard (View Users)

---

## 📂 Project Structure

### Backend
- Controller Layer
- Service Layer
- Repository Layer
- DTOs
- Security (JWT + Filters)

### Frontend
- Pages (Login, Signup, Dashboard)
- Services (API calls)
- Axios Instance
- Routing & Protected Routes

---

## ⚙️ Setup Instructions

### 🔹 Backend Setup

1. Clone the repository:
   https://github.com/DevKaustubh915/botmakers_assignment.git
2.go to backend folder
    cd botmakers
3.configure databse in application.properties
  spring.datasource.url=jdbc:mysql://localhost:3306/your_db
  spring.datasource.username=root
  spring.datasource.password=your_password
4. run backend
   mvn spring-boot:run

### 🔹 FrontEnd Setup
1. go to frontend folder
   cd botmakersfrontend
2. install dependancies
   npm install
3. run frontend
   npm run dev
