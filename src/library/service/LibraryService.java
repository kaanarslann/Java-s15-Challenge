package library.service;

import library.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LibraryService {

    Author danBrown = new Author(1, "Dan Brown");
    Author agathaChristie = new Author(2, "Agatha Christie");
    Author stephenKing = new Author(3, "Stephen King");
    Author jkRowling = new Author(4, "JK Rowling");
    Author tracyKidder = new Author(5, "Tracy Kidder");
    Author charlesPetzold = new Author(6, "Charles Petzold");
    Author ronaldRivest = new Author(7, "Ronald Rivest");
    Author michaelCiletti = new Author(8, "Michael Ciletti");

    Librarian librarianKaren = new Librarian(1, "Karen M.", "123456");

    Reader readerJim = new Reader(1, "Jim Halpert");
    Reader readerSheldon = new Reader(2, "Sheldon Cooper");

    MemberRecord recordJim = new MemberRecord(readerJim, "Scranton", "7856664512", LocalDateTime.now());

    MemberRecord recordSheldon = new MemberRecord(readerSheldon, "Pasadena", "5548652231", LocalDateTime.now());

    Library library = Library.getInstance();

    public void librarySetup() {

        Book daVinciCode = new Novels(1, danBrown, "The Da Vinci Code", "Fictional", 689);
        Book inferno = new Novels(2, danBrown, "Inferno", "Fictional", 642);
        Book orientExpress = new Novels(3, agathaChristie, "Murder on the Orient Express", "Fictional", 256);
        Book abcMurders = new Novels(4, agathaChristie, "The A.B.C. Murders", "Fictional", 256);
        Book it = new Novels(5, stephenKing, "It", "Fictional", 1138);
        Book shining = new Novels(6, stephenKing, "The Shining", "Fictional", 447);
        Book harryPotter = new Novels(7, jkRowling, "Harry Potter", "Fictional", 1114);
        Book fantasticBeasts = new Novels(8, jkRowling, "Fantastic Beasts", "Fictional", 614);
        Book soulOfNewMachine = new StudyBooks(9, tracyKidder, "The Soul of a New Machine", "Non Fictional", "Computer Engineering", "1st Edition", "Good");
        Book annotatedTuring = new StudyBooks(10, charlesPetzold, "The Annotated Turing", "Non Fictional", "Mathematics", "2nd Edition", "Excellent");
        Book intoToAlgorithms = new StudyBooks(11, ronaldRivest, "Intoduction to Algorithms", "Non Fictional", "Software Engineering", "1st Edition", "Bad");
        Book digitalDesign = new StudyBooks(12, michaelCiletti, "Digital Design", "Non Fictional", "Electrical Engineering", "3rd Edition", "Good");

        List<Book> danBrownBooks = new ArrayList<>();
        danBrownBooks.add(daVinciCode);
        danBrownBooks.add(inferno);
        danBrown.setBooks(danBrownBooks);

        List<Book> agathaChristieBooks = new ArrayList<>();
        agathaChristieBooks.add(orientExpress);
        agathaChristieBooks.add(abcMurders);
        agathaChristie.setBooks(agathaChristieBooks);

        List<Book> stephenKingBooks = new ArrayList<>();
        stephenKingBooks.add(it);
        stephenKingBooks.add(shining);
        stephenKing.setBooks(stephenKingBooks);

        List<Book> jkRowlingBooks = new ArrayList<>();
        jkRowlingBooks.add(harryPotter);
        jkRowlingBooks.add(fantasticBeasts);
        jkRowling.setBooks(jkRowlingBooks);

        List<Book> tracyKidderBooks = new ArrayList<>();
        tracyKidderBooks.add(soulOfNewMachine);
        tracyKidder.setBooks(tracyKidderBooks);

        List<Book> charlesPetzoldBooks = new ArrayList<>();
        charlesPetzoldBooks.add(annotatedTuring);
        charlesPetzold.setBooks(charlesPetzoldBooks);

        List<Book> ronaldRivestBooks = new ArrayList<>();
        ronaldRivestBooks.add(intoToAlgorithms);
        ronaldRivest.setBooks(ronaldRivestBooks);

        List<Book> michaelCilettiBooks = new ArrayList<>();
        michaelCilettiBooks.add(digitalDesign);
        michaelCiletti.setBooks(michaelCilettiBooks);

        library.newBook(daVinciCode);
        library.newBook(inferno);
        library.newBook(orientExpress);
        library.newBook(abcMurders);
        library.newBook(it);
        library.newBook(shining);
        library.newBook(harryPotter);
        library.newBook(fantasticBeasts);
        library.newBook(soulOfNewMachine);
        library.newBook(annotatedTuring);
        library.newBook(intoToAlgorithms);
        library.newBook(digitalDesign);

        readerSheldon.requestBorrow(abcMurders, librarianKaren);

        System.out.println("Library setup complete!");
    }

    public void libraryWelcomeMenu() {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("** Welcome to Workintech Library Service **");
            System.out.println("1. Login as a Reader");
            System.out.println("2. Login as a Librarian");
            System.out.println("3. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    readerMenu();
                    break;
                case 2:
                    librarianMenu();
                    break;
                case 3:
                    isRunning = false;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void libraryApp() {
        librarySetup();
        libraryWelcomeMenu();
    }

    public void readerMenu() {
        boolean inReaderMenu = true;
        while(inReaderMenu) {
            System.out.println("** Reader's Menu **");
            System.out.println("1. List All Books");
            System.out.println("2. Borrow A Book");
            System.out.println("3. Return A Book");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if(choice == 1) {
                Set<Book> books = readerJim.getBooks();
                for(Book book : books) {
                    System.out.println(book);
                }
            } else if(choice == 2) {
                List<Book> allBooks = library.listAllBooks();
                for(int i = 0; i < allBooks.size(); i++) {
                    Book book = allBooks.get(i);
                    System.out.println((i + 1) + ". " + book.getName() + "by " + book.getAuthor().getName());
                }
                System.out.println("Please choose a book from the list:");
                int bookChoice = scanner.nextInt() - 1;
                if(bookChoice >= 0 && bookChoice < allBooks.size()) {
                    Book chosenBook = allBooks.get(bookChoice);
                    readerJim.requestBorrow(chosenBook, librarianKaren);
                } else {
                    System.out.println("Invalid choice!");
                }
            } else if(choice == 3) {
                Set<Book> readerJimBooks = readerJim.getBooks();
                List<Book> allBooks = new ArrayList<>(readerJimBooks);
                for(int i = 0; i < allBooks.size(); i++) {
                    Book book = allBooks.get(i);
                    System.out.println((i + 1) + ". " + book.getName() + "by " + book.getAuthor().getName());
                }
                System.out.println("Please choose a book from the list:");
                int bookChoice = scanner.nextInt() - 1;
                if(bookChoice >= 0 && bookChoice < allBooks.size()) {
                    Book chosenBook = allBooks.get(bookChoice);
                    readerJim.returnBook(chosenBook, librarianKaren);
                } else {
                    System.out.println("Invalid choice!");
                }
            } else if(choice == 4) {
                System.out.println("Exiting Reader's Menu...");
                inReaderMenu = false;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public void librarianMenu() {
        boolean inLibrarianMenu = true;
        while(inLibrarianMenu) {
            System.out.println("** Librarian's Menu **");
            System.out.println("1. Filter Books");
            System.out.println("2. Add A New Book");
            System.out.println("3. Update A Book");
            System.out.println("4. Delete A Book");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if(choice == 1) {
                librarianFilterMenu();
            } else if(choice == 2) {
                librarianAddMenu();
            } else if(choice == 3) {
                librarianUpdateMenu();
            } else if(choice == 4) {
                librarianDeleteMenu();
            } else if(choice == 5) {
                inLibrarianMenu = false;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
    public void librarianFilterMenu() {
        boolean inFilterMenu = true;
        while(inFilterMenu) {
            System.out.println("** Filter Menu | Please choose a filter option:");
            System.out.println("1. Filter by Author");
            System.out.println("2. Filter by Category");
            System.out.println("3. Filter by Book Title");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);
            int filterChoice = scanner.nextInt();
            scanner.nextLine();

            if(filterChoice == 1) {
                System.out.println("Please enter an author name:");
                String authorName = scanner.nextLine().trim();
                System.out.println("Books by " + authorName + ":");
                List<Book> books = librarianKaren.filterByAuthor(authorName);
                for(Book book : books) {
                    System.out.println(book);
                }
            } else if(filterChoice == 2) {
                System.out.println("Please enter a category:");
                String category = scanner.nextLine().trim();
                System.out.println(category + " books:");
                List<Book> books = librarianKaren.filterByCategory(category);
                for(Book book : books) {
                    System.out.println(book);
                }
            } else if(filterChoice == 3) {
                System.out.println("Please enter a book title:");
                String bookTitle = scanner.nextLine().trim();
                System.out.println("Books titled " + bookTitle + ":");
                List<Book> books = librarianKaren.filterByTitle(bookTitle);
                for(Book book : books) {
                    System.out.println(book);
                }
            } else if(filterChoice == 4) {
                System.out.println("All books:");
                List<Book> books = librarianKaren.listAllBooks();
                for(Book book : books) {
                    System.out.println(book);
                }
            } else if(filterChoice == 5) {
                inFilterMenu = false;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public void librarianAddMenu() {
        boolean inAddMenu = true;
        while(inAddMenu) {
            System.out.println("** Add A New Book Menu | Please choose book type:");
            System.out.println("1. Novels");
            System.out.println("2. Study Books");
            System.out.println("3. Exit");

            Scanner scanner = new Scanner(System.in);
            int addChoice = scanner.nextInt();
            scanner.nextLine();

            if(addChoice == 1) {
                System.out.println("Please enter a book id:");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter a book title:");
                String bookTitle = scanner.nextLine().trim();
                System.out.println("Please enter a book category:");
                String bookCategory = scanner.nextLine().trim();
                System.out.println("Please enter a page count:");
                int bookPageCount = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter an author id:");
                int authorId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter an author name:");
                String authorName = scanner.nextLine().trim();

                Author newAuthor = new Author(authorId, authorName);
                Book newBook = new Novels(bookId, newAuthor, bookTitle, bookCategory, bookPageCount);
                List<Book> newAuthorsNewBook = new ArrayList<>();
                newAuthorsNewBook.add(newBook);
                newAuthor.setBooks(newAuthorsNewBook);

                librarianKaren.addBook(newBook);
                System.out.println("New novel added successfully!");
            } else if(addChoice == 2) {
                System.out.println("Please enter a book id:");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter a book title:");
                String bookTitle = scanner.nextLine().trim();
                System.out.println("Please enter a book category:");
                String bookCategory = scanner.nextLine().trim();
                System.out.println("Please enter a lecture name:");
                String bookLecture = scanner.nextLine().trim();
                System.out.println("Please enter an edition number:");
                String bookEdition = scanner.nextLine().trim();
                System.out.println("Please enter book condition:");
                String bookCondition = scanner.nextLine().trim();
                System.out.println("Please enter an author id:");
                int authorId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter an author name:");
                String authorName = scanner.nextLine().trim();

                Author newAuthor = new Author(authorId, authorName);
                Book newBook = new StudyBooks(bookId, newAuthor, bookTitle, bookCategory, bookLecture, bookEdition, bookCondition);
                List<Book> newAuthorsNewBook = new ArrayList<>();
                newAuthorsNewBook.add(newBook);
                newAuthor.setBooks(newAuthorsNewBook);

                librarianKaren.addBook(newBook);
                System.out.println("New study book added successfully!");
            } else if(addChoice == 3) {
                inAddMenu = false;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
    public void librarianUpdateMenu() {
        boolean inUpdateMenu = true;
        while(inUpdateMenu) {
            List<Book> allBooks = library.listAllBooks();
            for(int i = 0; i < allBooks.size(); i++) {
                Book book = allBooks.get(i);
                System.out.println((i + 1) + ". " + book.getName() + " by " + book.getAuthor().getName() + " .Category: " + book.getCategory());
            }
            System.out.println("Please choose a book from the list:");
            Scanner scanner = new Scanner(System.in);
            int bookChoice = scanner.nextInt() - 1;
            scanner.nextLine();
            if(bookChoice >= 0 && bookChoice < allBooks.size()) {
                Book chosenBook = allBooks.get(bookChoice);
                System.out.println("Please update the book title:");
                String newTitle = scanner.nextLine().trim();
                System.out.println("Please update the book category:");
                String newCategory = scanner.nextLine().trim();
                librarianKaren.updateBookInfo(chosenBook, newTitle, newCategory);
                inUpdateMenu = false;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
    public void librarianDeleteMenu() {
        boolean inDeleteMenu = true;
        while(inDeleteMenu) {
            List<Book> allBooks = library.listAllBooks();
            for(int i = 0; i < allBooks.size(); i++) {
                Book book = allBooks.get(i);
                System.out.println((i + 1) + ". " + book.getName() + " by " + book.getAuthor().getName());
            }
            System.out.println("Please choose a book from the list:");
            Scanner scanner = new Scanner(System.in);
            int bookChoice = scanner.nextInt() - 1;
            if(bookChoice >= 0 && bookChoice < allBooks.size()) {
                Book chosenBook = allBooks.get(bookChoice);
                librarianKaren.removeBook(chosenBook);
                inDeleteMenu = false;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
