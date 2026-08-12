🛠️ Technologies Used

Backend: Java 17, Spring Boot 3.2.5, Hibernate, Spring Security

Frontend: Thymeleaf, HTML5, CSS3

Database: MySQL

Tools & Libraries: Lombok, Maven

Server: Embedded Tomcat

✨ Features

🔑 User Authentication – Secure login/logout with Spring Security

📅 Car Booking System – Users can book cars with details stored in DB

🛠️ Admin Panel – Manage users, cars, and bookings

📂 File Uploading – Upload car images/documents

📄 Static Pages – Contact, About, Services

🔒 Password Security – BCrypt hashing for user credentials

📂 Project Structure

TaxiBookingSystem

│── src/main/java/com/taxi/
│   ├── controller/        # Handles HTTP requests
│   ├── service/           # Business logic
│   ├── repository/        # Database operations (JPA/Hibernate)
│   ├── model/             # Entity classes (User, Car, Booking)
│   └── security/          # Spring Security configuration
│
│── src/main/resources/
│   ├── templates/         # Thymeleaf HTML pages
│   ├── static/            # CSS, JS, images
│   └── application.properties  # DB + server config
│
└── pom.xml                # Maven dependencies
