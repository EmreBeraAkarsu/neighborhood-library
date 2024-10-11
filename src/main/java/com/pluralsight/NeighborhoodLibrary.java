package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Book[] books = new Book[20];
        Scanner scanner = new Scanner(System.in);


        Book book1 = new Book(123, "1252345234513", "Book1", false, "");
        Book book2 = new Book(35265, "37434736473467", "Book2", false, "");
        Book book3 = new Book(11234523, "67367367346573456", "Book3", false, "");
        Book book4 = new Book(4646, "78658658678", "Book4", false, "");
        Book book5 = new Book(1223453, "4524354352352345", "Book5", false, "");
        Book book6 = new Book(545435, "4567342562", "Book6", false, "");
        Book book7 = new Book(12636563, "7656845678536", "Book7", false, "");
        Book book8 = new Book(7747754, "62356233725345", "Book8", false, "");
        Book book9 = new Book(124443, "8736234562", "Book9", false, "");
        Book book10 = new Book(2222, "123455677", "Book10", true, "Mehmet");
        Book book11 = new Book(1446423, "42376567543267245234", "Book11", true, "Lavuk");
        Book book12 = new Book(166623, "78347456234652", "Book12", true, "kes");
        Book book13 = new Book(188823, "785348568563734", "Book13", true, "Leylek");
        Book book14 = new Book(127773, "2351432551345", "Book14", true, "Naber");
        Book book15 = new Book(1545523, "7324573473467347", "Book15", true, "Raymond");
        Book book16 = new Book(1244443, "347643734674788", "Book16", true, "nevar");
        Book book17 = new Book(1333323, "53462566675324", "Book17", true, "oyle");
        Book book18 = new Book(1000023, "73456236236", "Book18", true, "yeter");
        Book book19 = new Book(1215874373, "31313131313331", "Book19", true, "java");
        Book book20 = new Book(145854523, "6446466464664664", "Book20", true, "bugun");

        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        books[4] = book4;
        books[5] = book5;
        books[6] = book6;
        books[7] = book7;
        books[8] = book8;
        books[9] = book9;
        books[0] = book10;
        books[10] = book11;
        books[11] = book12;
        books[12] = book13;
        books[13] = book14;
        books[14] = book15;
        books[15] = book16;
        books[16] = book17;
        books[17] = book18;
        books[18] = book19;
        books[19] = book20;

        while (true) {

            System.out.println("Select from the following menu\n" +
                    "Show available books(1)\n" +
                    "Show checked out books(2)\n" +
                    "Exit(3)\n");
            String homeInput = scanner.nextLine();

            switch (homeInput) {

                case "1":
                    displayAvaliableBooks(scanner, books);
                    break;

                case "2":
                    displayCheckedOutBooks(scanner, books);
                    break;

                case "3":
                    System.out.println("GoodBye!");
                    return;

                default:
                    System.out.println("Wrong Option Picked!");
                    break;
            }
        }
    }

    public static void displayAvaliableBooks(Scanner scanner, Book[] books) {

        System.out.println("Available books: ");
        for (Book book : books) {
            if (!book.isCheckedOut()) {

                System.out.println(book.toString());
            }
        }

        while (true) {

            System.out.println("\nEnter 1 for select a book to check out or 2 to exit to the home screen");
            String displayAvailableBooksOption = scanner.nextLine();

            switch (displayAvailableBooksOption) {
                case "1":
                    checkOutABook(scanner, books);
                    break;

                case "2":
                    return;

                default:
                    System.out.println("Wrong Option Selected!");
                    break;
            }
        }
    }

    public static void displayCheckedOutBooks(Scanner scanner, Book[] books) {


        System.out.println("Checked out books: ");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book.toString());
            }
        }

        while (true) {

            System.out.println("\nEnter C to check in a book, X to go back to the home screen: ");
            String checkoutOption = scanner.nextLine();

            if (checkoutOption.equalsIgnoreCase("c")) {
                checkInABook(scanner, books);
            } else if (checkoutOption.equalsIgnoreCase("x")) {
                return;
            } else {
                System.out.println("Wrong option selected!");
            }
        }
    }

    public static void checkInABook(Scanner scanner, Book[] books) {

        while (true) {
            System.out.println("Enter the id of the book you want to return: ");
            int checkinId = scanner.nextInt();
            scanner.nextLine();

            for (Book book : books) {
                if (book.getId() == checkinId) {
                    System.out.println("Checking in " + book.toString());
                    book.checkIn();
                }
            }

            System.out.println("\nEnter Y to check in again, N to return to the home screen: ");
            String checkInReturnOption = scanner.nextLine();

            if (checkInReturnOption.equalsIgnoreCase("y")) {
                System.out.println("Checking in again");
            } else if (checkInReturnOption.equalsIgnoreCase("n")) {
                return;

            } else {
                System.out.println("Wrong option selected!");
            }
        }
    }

    public static void checkOutABook(Scanner scanner, Book[] books) {
        System.out.println("Enter the id of the book to check out: ");
        int checkoutId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your name: ");
        String checkoutName = scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == checkoutId) {
                System.out.println("Checking out " + book.toString());
                book.checkOut(checkoutName);

            }
        }
    }
}
