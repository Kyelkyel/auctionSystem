# auctionSystem

An online auction platform with a Java Spring Boot backend connected to a MySQL database, and a frontend built with HTML, CSS, and JavaScript.

---

## 🚀 Features

- Responsive frontend for browsing, searching, and filtering auctions
- Backend REST API built with Spring Boot handling business logic and database operations
- MySQL database for persistent storage of auction data, users, and bids
- Dynamic category filtering and live search powered by JavaScript on the frontend
- Secure and scalable architecture leveraging Spring Data JPA for CRUD operations

---

## 📂 Project Structure

```
auctionSystem/
│
├── backend/           # Spring Boot backend project
│   ├── src/
│   ├── pom.xml        # Maven dependencies including Spring Boot and MySQL connector
│   └── application.properties  # Database connection config
│
├── frontend/          # Static frontend files
│   ├── css/
│   ├── images/
│   ├── js/
│   └── index.html
│
├── database/          # MySQL database scripts and dumps
├── README.md
└── ...
```

---

## 🛠️ Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven (for building Spring Boot backend)
- MySQL Server installed and running
- A modern web browser

### Backend Setup (Spring Boot + MySQL)

1. Create MySQL Database:

   Using MySQL CLI or a GUI tool, create your database:

   ```sql
   CREATE DATABASE auctiondb;
   ```

2. Configure Spring Boot:

   In `src/main/resources/application.properties`, set your database connection:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/auctiondb?useSSL=false&serverTimezone=UTC
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

3. Add Dependencies:

   Ensure your `pom.xml` includes:

   ```xml
   
       org.springframework.boot
       spring-boot-starter-data-jpa
   
   
       mysql
       mysql-connector-java
       runtime
   
   ```

4. Build and Run Backend:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup

- Place the `frontend` folder contents in your web server root or serve statically.
- Access `index.html` via your browser.
- The frontend communicates with the Spring Boot backend REST API for dynamic data.

---

## 💡 Usage

- Browse and filter auctions via the frontend UI.
- Backend handles CRUD operations for auctions, bids, and users.
- Extend backend with controllers, services, and repositories as needed.

---

## 📄 Notes

- The backend uses Spring Data JPA for seamless MySQL integration and CRUD.
- The frontend is static and uses JavaScript to interact with backend APIs.
- For production, consider securing API endpoints and adding authentication.

---

## 🤝 Contributing

Contributions to both frontend and backend are welcome! Please submit issues or pull requests.

---

## 📬 Contact

For questions or support, open an issue or contact [Kyelkyel](https://github.com/Kyelkyel).


