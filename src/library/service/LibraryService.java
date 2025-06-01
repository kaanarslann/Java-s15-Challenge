package library.service;

import library.model.*;

import java.time.LocalDateTime;

public class LibraryService {

    public void LibrarySetup() {
        Author danBrown = new Author(1, "Dan Brown");
        Author agathaChristie = new Author(2, "Agatha Christie");
        Author stephenKing = new Author(3, "Stephen King");
        Author jkRowling = new Author(4, "JK Rowling");
        Author tracyKidder = new Author(5, "Tracy Kidder");
        Author charlesPetzold = new Author(6, "Charles Petzold");
        Author ronaldRivest = new Author(7, "Ronald Rivest");
        Author michaelCiletti = new Author(8, "Michael Ciletti");

        Book daVinciCode = new Novels(1, danBrown, "The Da Vinci Code", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 689);
        Book inferno = new Novels(2, danBrown, "Inferno", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 642);
        Book orientExpress = new Novels(3, agathaChristie, "Murder on the Orient Express", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 256);
        Book abcMurders = new Novels(4, agathaChristie, "The A.B.C. Murders", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 256);
        Book it = new Novels(5, stephenKing, "It", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 1138);
        Book shining = new Novels(6, stephenKing, "The Shining", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 447);
        Book harryPotter = new Novels(7, jkRowling, "Harry Potter", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 1114);
        Book fantasticBeasts = new Novels(8, jkRowling, "Fantastic Beasts", "Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), 614);
        Book soulOfNewMachine = new StudyBooks(9, tracyKidder, "The Soul of a New Machine", "Non Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), "Computer Engineering", "1st Edition", "Good");
        Book annotatedTuring = new StudyBooks(10, charlesPetzold, "The Annotated Turing", "Non Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), "Mathematics", "2nd Edition", "Excellent");
        Book intoToAlgorithms = new StudyBooks(11, ronaldRivest, "Intoduction to Algorithms", "Non Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), "Software Engineering", "1st Edition", "Bad");
        Book digitalDesign = new StudyBooks(12, michaelCiletti, "Digital Design", "Non Fictional", BookStatus.AVAILABLE, LocalDateTime.now(), "Electrical Engineering", "3rd Edition", "Good");


    }



}
