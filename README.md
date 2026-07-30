# 📚 Library Management System

A console-based **Library Management System** developed in **Java** using **JDBC** and **MySQL**. The application demonstrates CRUD operations, database connectivity, object-oriented programming principles, and a menu-driven interface.

---

## ✨ Features

- ➕ Add a new book
- 📖 Display all books
- 📥 Borrow a book
- 📤 Return a borrowed book
- 💾 Store and retrieve data using MySQL
- 🖥️ Menu-driven console interface

---

## 🛠️ Technologies Used

- Java 25
- JDBC (Java Database Connectivity)
- MySQL Server
- MySQL Workbench
- MySQL Connector/J 9.x
- IntelliJ IDEA Community Edition
- Git & GitHub

---

## 📂 Project Structure

```text
LibraryManagementSystem
│
├── src
│   └── com.library
│       ├── config
│       │   └── DatabaseConnection.java
│       │
│       ├── exception
│       │   ├── BookNotFoundException.java
│       │   └── BookUnavailableException.java
│       │
│       ├── model
│       │   └── Book.java
│       │
│       ├── service
│       │   └── LibraryService.java
│       │
│       └── Main.java
│
├── .gitignore
└── README.md
```

---

## 🗄️ Database

### Database Name

```sql
library_db
```

### Table Name

```sql
books
```

### Table Structure

| Column | Type | Description |
|---------|------|-------------|
| id | INT | Primary Key (Auto Increment) |
| title | VARCHAR(255) | Book Title |
| author | VARCHAR(255) | Author Name |
| is_available | BOOLEAN | Book Availability |

---

## ⚙️ Database Configuration

Update the database credentials in:

```text
src/com/library/config/DatabaseConnection.java
```

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USERNAME = "root";
private static final String PASSWORD = "YOUR_PASSWORD";
```

Replace `YOUR_PASSWORD` with your local MySQL password.

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Siddhesh31736/LibraryManagementSystem.git
```

### 2. Open the project

Open the project in **IntelliJ IDEA**.

### 3. Create the database

```sql
CREATE DATABASE library_db;
USE library_db;
```

### 4. Create the table

```sql
CREATE TABLE books(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    is_available BOOLEAN DEFAULT TRUE
);
```

### 5. Configure MySQL

Update the database credentials inside:

```text
DatabaseConnection.java
```

### 6. Add MySQL Connector/J

Add the MySQL Connector/J JAR to your project libraries.

### 7. Run

Run:

```text
Main.java
```

---

## 📸 Sample Menu

```text
===== Library Management System =====

1. Add Book
2. Display Books
3. Borrow Book
4. Return Book
5. Exit

Enter your choice:
```
