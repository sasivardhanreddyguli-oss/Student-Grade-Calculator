# GradeWise – Student Grade Calculator

A responsive Java web application built with Java 17, Spring Boot, Thymeleaf, HTML, CSS, JavaScript, Spring Data JPA and the H2 database.

## Features
- Enter a student name and marks for three subjects.
- Calculate total, average and grade.
- Save results to an H2 database.
- View saved student results in a table.
- Delete saved results.
- Responsive layout for desktop, tablet and mobile.
- Input validation on both the browser and server.

## Grade scale
| Average | Grade |
|---|---|
| 90–100 | A+ |
| 80–89.99 | A |
| 70–79.99 | B |
| 60–69.99 | C |
| 50–59.99 | D |
| Below 50 | F |

Each subject is out of 100. Total is the sum of three marks; average is total divided by three. This is a sample grading scale and can be adjusted to match your institution.

## Requirements
- Java Development Kit (JDK) 17 or later
- Maven 3.6+ (or use an IDE with Maven support)

## Run in IntelliJ IDEA / Eclipse / VS Code
1. Extract the ZIP file.
2. Open the `Student_Grade_Calculator` folder as a Maven project.
3. Ensure JDK 17 is selected.
4. Run `GradeCalculatorApplication.java`.
5. Open http://localhost:8080 in your browser.

Alternatively, from the project folder run:
```bash
mvn spring-boot:run
```

## Database
The project uses an embedded H2 file database. Results are stored in `./data/gradesdb` and remain available after restarting the app. The optional H2 console is at http://localhost:8080/h2-console.
- JDBC URL: `jdbc:h2:file:./data/gradesdb`
- Username: `sa`
- Password: leave blank

## Project structure
```text
Student_Grade_Calculator/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/com/example/gradecalculator/
        │   ├── GradeCalculatorApplication.java
        │   ├── GradeController.java
        │   ├── GradeService.java
        │   ├── StudentResult.java
        │   └── StudentResultRepository.java
        └── resources/
            ├── application.properties
            ├── static/
            │   ├── app.js
            │   └── style.css
            └── templates/
                └── index.html
```

## Notes
This is an educational project with a local H2 database. It does not include user accounts, cloud hosting or institutional grading rules. Test it locally before submitting.
