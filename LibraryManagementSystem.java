// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

abstract class Item {
    String title;
    String author;
    int year;
    boolean available;

    public Item(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    abstract void checkOut();

    abstract void returnItem();

    abstract void displayDetails();
}

class Book extends Item {
    String genre;

    public Book(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    void checkOut() {
        if (available) {
            available = false;
            System.out.println("Book '" + title + "' checked out successfully!");
        } else {
            System.out.println("Book '" + title + "' is not available for checkout.");
        }
    }

    @Override
    void returnItem() {
        available = true;
        System.out.println("Book '" + title + "' returned successfully!");
    }

    @Override
    void displayDetails() {
        String availability = available ? "Yes" : "No";
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year + ", Genre: " + genre + ", Available: " + availability);
    }
}

class DVD extends Item {
    int duration;

    public DVD(String title, String author, int year, int duration) {
        super(title, author, year);
        this.duration = duration;
    }

    @Override
    void checkOut() {
        if (available) {
            available = false;
            System.out.println("DVD '" + title + "' checked out successfully!");
        } else {
            System.out.println("DVD '" + title + "' is not available for checkout.");
        }
    }

    @Override
    void returnItem() {
        available = true;
        System.out.println("DVD '" + title + "' returned successfully!");
    }

    @Override
    void displayDetails() {
        String availability = available ? "Yes" : "No";
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year + ", Duration: " + duration + " mins, Available: " + availability);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> library = new ArrayList<>();

        while (true) {
            System.out.println("\nWelcome to the Library Management System!\n");
            System.out.println("1. Add Book");
            System.out.println("2. Add DVD");
            System.out.println("3. Display Available Items");
            System.out.println("4. Check Out Item");
            System.out.println("5. Return Item");
            System.out.println("6. Exit");

            System.out.print("\nPlease enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter genre: ");
                    String genre = scanner.next();
                    Book book = new Book(bookTitle, author, year, genre);
                    library.add(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    // Add DVD
                    System.out.print("Enter DVD title: ");
                    String dvdTitle = scanner.next();
                    System.out.print("Enter director: ");
                    String director = scanner.next();
                    System.out.print("Enter release year: ");
                    int dvdYear = scanner.nextInt();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    DVD dvd = new DVD(dvdTitle, director, dvdYear, duration);
                    library.add(dvd);
                    System.out.println("DVD added successfully!");
                    break;

                case 3:
                    // Display Available Items
                    System.out.println("\nAvailable Items:");
                    for (Item item : library) {
                        item.displayDetails();
                    }
                    break;

                case 4:
                    // Check Out Item
                    System.out.print("Enter the title of the item you want to check out: ");
                    String checkoutTitle = scanner.next();
                    for (Item item : library) {
                        if (item.title.equals(checkoutTitle)) {
                            item.checkOut();
                            break;
                        }
                    }
                    break;

                case 5:
                    // Return Item
                    System.out.print("Enter the title of the item you want to return: ");
                    String returnTitle = scanner.next();
                    for (Item item : library) {
                        if (item.title.equals(returnTitle)) {
                            item.returnItem();
                            break;
                        }
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}
