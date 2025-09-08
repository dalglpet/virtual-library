# 📚 Library Management System (Java)

A simple console-based library application written in Java. Users can add books to the library, search for them by different criteria, view all entries, and display results sorted by publication year or author last name.

---

## ✨ Features
• Add books manually by entering ISBN, title, author, genre, and year  
• Search by ISBN, title (contains keyword), author, or genre  
• List all books in the library  
• View books sorted by publication year (selection sort) or author last name (insertion sort)  

---

## 🛠️ Technologies
• Java (OOP principles)  
• Basic algorithms (selection and insertion sort)  
• Console-based user interface with menus  

---

## 🚀 How to Run
1. Clone this repository:  
   git clone https://github.com/your-username/library-management-java.git
   cd library-management-java

2. Compile the project:  
   javac main/*.java

3. Run the program:  
   java main.Main

---

## 📂 Project Structure
├── main/
│   ├── Main.java      # Entry point, menu system, and user interaction
│   ├── Library.java   # Manages collection of books, search & sort methods
│   └── Book.java      # Book model with fields and toString()

---

📌 Future Improvements  
	• Add update and delete functionality for books  
	• Persist data to a file or database  
	• Case-insensitive search and partial matching for author/genre  
	• Add unit tests for Library methods  

⸻

📜 License  

This project is licensed under the MIT License – see the LICENSE file for details.  

⸻

👤 Developed by [Your Name]  
💡 Contributions, issues, and suggestions are welcome!  
