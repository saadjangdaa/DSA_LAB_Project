# Student Management System (Using ArrayList in Java)

## Overview
A complete Student Record Management System built in Java using ArrayList data structure.

## Features
✓ **Add Student** - Add new student records with ID, Name, and Marks  
✓ **Update Student** - Modify existing student information  
✓ **Delete Student** - Remove student records from the system  
✓ **Search by ID** - Find student using Student ID  
✓ **Search by Name** - Find student using Name (partial search supported)  
✓ **Display All** - View all student records in a formatted table  

## Data Structure
- Uses **ArrayList<Student>** for dynamic storage
- Stores: Student ID, Name, and Marks
- Prevents duplicate IDs
- Validates marks (0-100 range)

## Files
- `Student.java` - Student class with properties and getters/setters
- `StudentManagementSystem.java` - Main application with all operations

## How to Compile and Run

### Using Command Line:
```bash
javac Student.java
javac StudentManagementSystem.java
java StudentManagementSystem
```

### Using IDE (IntelliJ, Eclipse, VS Code):
1. Create a new Java project
2. Copy both files to the project folder
3. Run `StudentManagementSystem` class

## Usage Example

```
Menu Options:
1. Add Student - Enter ID, Name, and Marks
2. Update Student - Modify existing student details
3. Delete Student - Remove a student with confirmation
4. Search by ID - Find specific student by ID
5. Search by Name - Search by full or partial name
6. Display All - View all students in table format
7. Exit - Close the program
```

## Advantages of ArrayList over Array
- Dynamic size - grows automatically
- Easy add/remove operations
- Built-in methods for common operations
- No need to manage size manually

## Input Validation
- Student IDs must be unique
- Names cannot be empty
- Marks must be between 0-100
- ID must be numeric

---
**Merged from:** huzaifa/, rafay/, uqbah/ folders  
**Technology:** Java 8+
