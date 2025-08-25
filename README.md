Matador Pro – Mini-Bus Seat Booking Application

Matador Pro is a desktop application built with Java Swing that enables efficient mini-bus seat booking. It delivers a user-friendly interface for selecting seats, booking tickets, and managing reservations—all within a lightweight and intuitive GUI.

Features

Seat Selection Interface: Visual seating layout allowing users to choose available seats.

Booking Management: Users can reserve seats and receive immediate booking confirmation.

Database Integration: Stores booking details using a local database (SQL-based backup included).

Simple & Clean UI: Built entirely with Java Swing for a responsive and familiar desktop experience.

Demo & License

Live Demo: Available at the [hosted app link]
GitHub
.

License: Distributed under the GNU GPL-3.0 License, ensuring it remains free and open-source. 
GitHub

Installation & Setup

Clone the repository

git clone https://github.com/mmaismma/matador-pro.git


Import into your IDE (e.g., IntelliJ IDEA, Eclipse) via the existing pom.xml (Maven configuration).

Setup the database: Use the included db_backup.sql file to create the required database and tables.

Run the application: Launch via your IDE or use Maven to build and execute.

Project Structure
matador-pro/
├── src/main/              # Java source code (Swing GUI, business logic)
├── db_backup.sql          # SQL schema/data backup
├── pom.xml                # Maven project configuration
├── LICENSE                # GPL-3.0 license
└── README.md              # Project documentation

Technologies
Category	Tools & Frameworks
Language	Java
GUI Framework	Swing (Java Swing toolkit)
Build Tool	Maven
Database	SQL (schema provided in db_backup.sql)
License	GNU GPL-3.0
Contribution

Contributions are welcome! If you'd like to enhance features such as seat layout design, add export functionality, or improve reservation flow:

Fork the repository

Create a descriptive branch

Submit a pull request—let's build this together!

Contact

For suggestions or feedback, please open an issue in the repository or reach out to the contributors listed on GitHub.
