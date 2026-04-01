# 📝 Todo List API (Spring Boot)

A simple and efficient Todo List REST API built using **Spring Boot**, **Spring Data JPA**, and **H2 Database**.
This project demonstrates CRUD operations and backend fundamentals for managing tasks.

---

## 🚀 Features

* ✅ Add new task
* 📋 Get all tasks
* ✏️ Update task
* ❌ Delete task
* 💾 In-memory database (H2)
* 🔄 RESTful API design

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* Lombok
* Maven

---

## 📂 Project Structure

```
src/
 └── main/
     ├── java/
     │   └── com/example/todo/
     │       ├── controller/
     │       ├── service/
     │       ├── repository/
     │       └── model/
     └── resources/
         ├── application.properties
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone Repository

```
git clone https://github.com/Prathamdiwakar/todo-List-Api.git
cd todo-List-Api
```

### 2️⃣ Run Application

```
./mvnw spring-boot:run
```

---

## 🌐 API Endpoints

| Method | Endpoint    | Description     |
| ------ | ----------- | --------------- |
| POST   | /tasks      | Create new task |
| GET    | /tasks      | Get all tasks   |
| PUT    | /tasks/{id} | Update task     |
| DELETE | /tasks/{id} | Delete task     |

---

## 🗄️ H2 Database

Access H2 Console:

```
http://localhost:8080/h2-console
```

**JDBC URL:**

```
jdbc:h2:mem:testdb
```

---

## 📸 Sample Request (POST)

```
{
  "title": "Learn Spring Boot",
  "completed": false
}
```

---


## 📌 Future Improvements

* 🔐 Add authentication (JWT)
* 🧾 Validation handling
* 🌍 Deploy on cloud (Render / Railway)
* 🎨 Connect frontend (React)

---

## 👨‍💻 Author

**Pratham Diwakar**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
