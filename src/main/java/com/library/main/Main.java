package com.library.main;

import com.library.service.Library;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     WELCOME TO WORLD LIBRARY       ║");
        System.out.println("╚════════════════════════════════════╝");


        while (true){
            displayMenu();
            System.out.println("Enter your choice : ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch (Exception e){
                scanner.nextLine();
                System.out.println("❌ Invalid input! Please enter a number.");
                continue;
            }

            switch (choice){
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    library.showAllBooks();
                    break;

                case 3:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    library.registerUser(userName);
                    break;

                case 4:
                    library.showAllUsers();
                    break;

                case 5:
                    System.out.print("Enter user ID: ");
                    int userIdBorrow = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book ID to borrow: ");
                    int bookIdBorrow = scanner.nextInt();
                    scanner.nextLine();
                    library.borrowBook(userIdBorrow, bookIdBorrow);
                    break;

                case 6:
                    System.out.print("Enter user ID: ");
                    int userIdReturn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book ID to return: ");
                    int bookIdReturn = scanner.nextInt();
                    scanner.nextLine();
                    library.returnBook(userIdReturn, bookIdReturn);
                    break;

                case 7:
                    System.out.print("Enter user ID to view borrowed books: ");
                    int userIdShow = scanner.nextInt();
                    scanner.nextLine();
                    library.showUserBorrowedBooks(userIdShow);
                    break;

                case 8:
                    System.out.println("👋 Exiting... Thank you for using World Library!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         LIBRARY MENU               ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. ➕ Add Book                     ║");
        System.out.println("║ 2. 📚 Show All Books               ║");
        System.out.println("║ 3. 👤 Register User                ║");
        System.out.println("║ 4. 👥 Show All Users               ║");
        System.out.println("║ 5. 📖 Borrow Book                  ║");
        System.out.println("║ 6. 🔁 Return Book                  ║");
        System.out.println("║ 7. 📋 Show User's Borrowed Books   ║");
        System.out.println("║ 8. 🚪 Exit                         ║");
        System.out.println("╚════════════════════════════════════╝");
    }
}