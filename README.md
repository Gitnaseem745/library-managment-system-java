# Library Borrowing System

## Overview
This project is a **Library Borrowing System** built in Java. It allows students to borrow and return books based on their availability. Books are categorized by genres and authors, and students can select books from various genres. The system also calculates the total price of borrowing based on the number of days the book is borrowed.
## Table of Contents
- [Features](#features)
- [Classes and Components](#classes-and-components)
- [Installation and Setup](#installation-and-setup)
- [Sample Execution](#sample-execution)

---
## Features
- **Book Borrowing**: Students can borrow available books by selecting a genre, author, and book.
- **Book Returning**: Students can return books by providing the book ID.
- **Dynamic Pricing**: Borrowing prices are calculated based on the number of days the book is borrowed.
- **Genre and Author Filtering**: Students can choose books based on genres and authors.
- **Multiple Genres**: The system includes genres like Science Fiction, Fantasy, Horror, Mystery, Romance, Historical Fiction, and more.

## Classes and Components
- **Book**: Represents a book with attributes such as name, ID, genre, author, daily price, and availability.
- **Student**: Represents a student with details like name, ID, course, and year.
- **Borrow**: Manages the borrowing record, storing information about which student borrowed which book for how many days.
- **BorrowSystem**: The main class that handles the core operations of adding books, students, borrowing, and returning books.

### Main Functionalities
1. **Add Books and Students**: The system allows adding books and students into the library system.
2. **Borrow a Book**: A student can borrow an available book by selecting a genre, author, and book.
3. **Return a Book**: A student can return a book by providing its ID, and the system updates the book’s availability.
4. **Display Available Genres and Authors**: The system displays available genres and authors dynamically to allow easy selection.

## Installation and Setup

### Requirements
- **Java 8** or higher

### Steps to Run
1. Clone the repository or download the source code.
   ```bash
   git clone https://github.com/Gitnaseem745/library-managment-system-java.git
   cd library-managment-system-java
   ```
2. Compile the Java files.
   ```bash
   javac Main.java
   ```
3. Run the program.
   ```bash
   java Main
   ```

## Sample Execution

```bash
==== Welcome to our Library ====
1. Borrow a Book.
2. Return a Borrowed Book.
3. Exit.

Enter Your Choice: 1

== All Available Genres ==
0. Science fiction
1. Fantasy
2. Horror
...

Choose Your Genre: 0

== All Available Authors ==
0. Frank Herbert
1. William Gibson
2. Ursula K. Le Guin
...

Choose Your Author: 0

== All Available Books ==
0. Dune | B001 | Frank Herbert | Science fiction
...

Choose Your Book Id: B001
Enter Your Name: John Doe
Enter Your Course: Computer Science
Enter Your Course Year: 2
Enter the Number of Days You Want To Borrow: 5

The Price for Borrow is: $64.95
Do You Want To Continue (Y/N): Y

John Doe from Computer Science 2 Year Borrowed Dune by Frank Herbert from Science fiction Genre for 5 Days at $64.95.
```
