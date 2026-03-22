# Generic-Library-Management-System-Using-Java

## Description
A console-based Library Management System written in Java that demonstrates the use of **generics**, **custom exceptions**, and **collections**.  
The program allows users to add books, display all books, search for a book by ID, and exit. It uses a generic `Library<T extends Book>` class to store any type that extends `Book`, showcasing flexibility and type safety.

## Features
- **Add Books** – Add a new book with ID, title, and author.
- **Display All Books** – Show all books currently in the library.
- **Search by ID** – Find a book by its ID; throws `BookNotFoundException` if not found.
- **Custom Exception** – `BookNotFoundException` provides meaningful error messages.
- **Generic Library Class** – Can be extended to hold any subtype of `Book`.
- **Clean Console Interface** – Simple menu-driven interaction.

## Algorithm

### 1. Class Structure

#### `Book` class
- Fields: `int id`, `String title`, `String author`
- Constructor to initialize fields.
- `display()` method to print book details.

#### `BookNotFoundException` (custom exception)
- Extends `Exception`.
- Constructor that takes a message and passes it to `super(msg)`.

#### `Library<T extends Book>` (generic class)
- Stores a generic `ArrayList<T>`.
- `addBook(T book)`: Adds a book to the list and prints success.
- `showBooks()`: Displays all books; prints “Library is empty” if none.
- `searchBook(int id)`: Searches for a book by ID; displays it if found, else throws `BookNotFoundException`.

### 2. Main Program (`unitproject4`)
- Creates a `Scanner` for user input.
- Instantiates a `Library<Book>`.
- Infinite loop displaying menu:
  1. Add Book – prompts for ID, title, author; calls `addBook`.
  2. Display Books – calls `showBooks`.
  3. Search Book – prompts for ID; tries `searchBook` and catches the custom exception.
  4. Exit – prints message and returns.
- Handles invalid choices.
