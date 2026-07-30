package com.library;
import java.util.Scanner;
import com.library.service.LibraryService;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while(true) {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Books");
            System.out.println("4. Return Books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    service.addBook(title, author);

                    break;

                case 2:
                    service.displayBooks();

                    break;

                case 3:
                    System.out.print("Enter Id: ");
                    int borrowId = sc.nextInt();
                    sc.nextLine();

                    service.borrowBook(borrowId);

                    break;

                case 4:
                    System.out.print("Enter Id: ");
                    int returnId = sc.nextInt();
                    sc.nextLine();

                    service.returnBook(returnId);

                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
