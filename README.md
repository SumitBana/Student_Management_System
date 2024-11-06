# Student Management System

A Java-based application that provides a comprehensive platform for managing student data. This system allows users to perform various operations like adding new students, viewing existing records, updating student details, and deleting entries, all through an intuitive graphical user interface (GUI).

#Note : TABLE SCHEMAS IS PROVIDED IN THE DOCUMENTS FOLDER.

## Features

- User authentication (Admin, Professor, Student roles)
- Student management (Add, Edit, Delete)
- Professor management (Add, Edit, Delete)
- Grade assignment and editing
- View student details and grades
- Print functionality for student information and grades

## Technical Details

- Language: Java
- Database: MySQL
- GUI: Swing

## Main Components

1. `LoginMain.java`: Entry point of the application, handles user login
2. `SignupFrame.java`: Allows new user registration
3. `MainFrame.java`: Main interface with menu options for different roles
4. `StudentAddFrame.java`: Interface for adding new students
5. `ProfessorAddFrame.java`: Interface for adding new professors
6. `StudentEditFrame.java`: Interface for editing student information
7. `ProfessorEditFrame.java`: Interface for editing professor information
8. `GradeAssign.java`: Interface for assigning and editing grades
9. `StudentSnapshot.java`: Displays a snapshot of all students and their grades
10. `ViewDetailByStudent.java`: Allows students to view their personal details
11. `ViewGradeByStudent.java`: Allows students to view their grades

## Setup

1. Ensure you have Java and MySQL installed on your system
2. Set up the MySQL database with the required tables (USER, STUDENT_MASTER, PROFESSOR_MASTER, PROFESSOR_DEGREE, STUDENT_GRADE)
3. Update the database connection details in the relevant Java files
4. Compile and run the `LoginMain.java` file to start the application

## Usage

1. Log in with your credentials (Admin, Professor, or Student)
2. Navigate through the menu options to perform various tasks based on your role
3. Admin can manage both students and professors
4. Professors can assign and edit grades, and view student information
5. Students can view their personal details and grades

## Screenshots of the program :
<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/2c2dc2f2-cb5a-4842-ad11-8c9cdebdec21" alt="Screenshot 1" width="300"></td>
    <td><img src="https://github.com/user-attachments/assets/42135a66-c429-4a40-9a3a-e3f292074d2c" alt="Screenshot 3" width="300"></td>
    <td><img src="https://github.com/user-attachments/assets/9faf2eb6-6ede-4130-9f92-87a3c0c1a101" alt="Screenshot 4" width="300"></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/47cd6a30-af09-445f-885a-a1e85b049d04" alt="Screenshot 2" width="300"></td>
    <td><img src="https://github.com/user-attachments/assets/28d7d8a4-79ae-4a48-86d6-abd881de7fb8" alt="Screenshot 5" width="300"></td>
    <td><img src="https://github.com/user-attachments/assets/df28b6c9-b61b-4814-b547-828515fa68aa" alt="Screenshot 6" width="300"></td>
  </tr>
</table>


## License

This project is open source. Feel free to use, modify, and distribute it as per the licensing terms.

## Contact
For any questions, feel free to reach out: <br>
GitHub: SumitBana <br>
Email: sumitworks1508@example.com
