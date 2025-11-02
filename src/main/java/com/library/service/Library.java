package com.library.service;

import com.library.model.Book;
import com.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private int nextBookId = 1;
    private int nextUserId = 1;

    public  Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    //functions
    public void addBook(String title, String author) {
        Book book = new Book(nextBookId++, author, title);
        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle() + " (ID: " + book.getBookId() + ")");
    }
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books in the library yet!");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }
        if (book == null) {
            System.out.println("❌ Book not found!");
            return;
        }

        if (book.borrow(bookId)) {
            user.borrowBooks(book);
            System.out.println("📖 " + user.getUserName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("❌ Book is already borrowed!");
        }
    }

    public void returnBook(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        if (user == null || book == null) {
            System.out.println("❌ Invalid user or book ID!");
            return;
        }

        if (book.returnBook(bookId)) {
            user.returnBooks(book);
            System.out.println("🔁 " + user.getUserName() + " returned: " + book.getTitle());
        } else {
            System.out.println("❌ Book was not borrowed!");
        }
    }

    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) return user;
        }
        return null;
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) return book;
        }
        return null;
    }

    public void showUserBorrowedBooks(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("❌ User not found!");
            return;
        }

        // Use the User's own method to show borrowed books
        user.showBorrowedBooks();
    }


    public void registerUser(String userName) {
        User user = new User(userName, nextUserId++, userName.toLowerCase().replace(" ", "") + "@library.com");
        users.add(user);
        System.out.println("✅ User registered: " + user.getUserName() + " (ID: " + user.getUserId() + ")");
    }
    public void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("❌ No users registered yet!");
            return;
        }

        System.out.println("\n👥 === ALL USERS ===");
        for (User user : users) {
            System.out.println(user);
        }
    }


}
