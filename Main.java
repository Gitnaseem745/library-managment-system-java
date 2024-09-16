import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

class Book{
    private String name;
    private String bookId;
    private String genre;
    private String author;
    private double dailyPrice;
    private boolean isAvailable;

    public Book(String name, String bookId, String genre, String author, double dailyPrice){
        this.name = name;
        this.bookId = bookId;
        this.genre = genre;
        this.author = author;
        this.dailyPrice = dailyPrice;
        this.isAvailable = true;
    }

    public String getName(){
        return name;
    }
    public String getBookId(){
        return bookId;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public double getTotalPrice(int days){
        return dailyPrice*days;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }
    public void borrow(){
        isAvailable = false;
    }
    public void returnBook(){
        isAvailable = true;
    }
}
class Student{
    private String name;
    private String course;
    private int year;
    public Student(String name, String course, int year){
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public String getStudentName(){
        return name;
    }
    public String getCourse(){
        return course;
    }
    public int getYear(){
        return year;
    }
}
class BorrowSystem{
    List<Book> books;
    List<Student> students;
    String author;
    String[] genres = {
        "Science fiction",
        "Fantasy",
        "Horror",
        "Mystery",
        "Romance novel",
        "Historical fiction",
        "Adventure fiction",
        "Literary fiction",
        "Thriller",
    };
    List<List<String>> authorsByGenre = Arrays.asList(
    Arrays.asList("Frank Herbert", "William Gibson", "Ursula K. Le Guin", "Aldous Huxley", "Ray Bradbury", "Cormac McCarthy", "Isaac Asimov", "Neal Stephenson", "Dan Simmons"),  // Science fiction
    Arrays.asList("J.R.R. Tolkien", "George R.R. Martin", "Patrick Rothfuss", "Brandon Sanderson", "Scott Lynch", "Stephen King", "Brent Weeks", "Andrzej Sapkowski"),  // Fantasy
    Arrays.asList("Bram Stoker", "Stephen King", "Mary Shelley", "William Peter Blatty", "Shirley Jackson", "Mark Z. Danielewski", "Josh Malerman"),  // Horror
    Arrays.asList("Stieg Larsson", "Gillian Flynn", "Dan Brown", "Arthur Conan Doyle", "Agatha Christie", "Raymond Chandler", "Dashiell Hammett", "Liane Moriarty"),  // Mystery
    Arrays.asList("Jane Austen", "Diana Gabaldon", "Nicholas Sparks", "Charlotte Brontë", "Jojo Moyes", "Graeme Simsion", "Jamie McGuire", "E.L. James"),  // Romance novel
    Arrays.asList("Leo Tolstoy", "Kristin Hannah", "Anthony Doerr", "Markus Zusak", "Ken Follett", "Kathryn Stockett", "Charles Belfoure"),  // Historical fiction
    Arrays.asList("Jack London", "Robert Louis Stevenson", "Arthur Conan Doyle", "Jon Krakauer", "Yann Martel", "Jules Verne"),  // Adventure fiction
    Arrays.asList("Harper Lee", "J.D. Salinger", "F. Scott Fitzgerald", "George Orwell", "Herman Melville", "Gabriel García Márquez"),  // Literary fiction
    Arrays.asList("Thomas Harris", "Paula Hawkins", "Robert Ludlum", "Dennis Lehane", "S.J. Watson", "Tim Lebbon")  // Thriller
);
    public BorrowSystem(){
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void addStudent(Student student){
        students.add(student);
    }
    // checking if books are added in the list or not
    public void getAllBooksName(){
        for(int i=0; i<books.size(); i++){
            System.out.println(books.get(i).getName());
        }
    }
    public void mainMenu(){
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n== Welcome to our Library ==\n");
            System.out.println("1. Borrow a Book.");
            System.out.println("2. Return a Borrowed Book.");
            System.out.println("3. Exit.");
            System.out.println("\nEnter Your Choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    genreMenu(scan);
                    break;

                default:
                    break;
            }

        } while (choice != 3);
    }
    public void genreMenu(Scanner scan){
        System.out.println("\n== All Available Genres ==\n");
        int i = 0;
        for(String genre : genres){
            System.out.println(i + "." + " " + genre);
            i++;
        }
        System.out.println("\nChoose Your Genre: ");
        int selectedGenre = scan.nextInt();
        if(selectedGenre >= genres.length){
            System.out.println("\nError Selected Genre Not Found!");
        }
        chooseAuthor(scan, selectedGenre);
    }
    public void chooseAuthor(Scanner scan, int selectedGenre){
        System.out.println("\n== All Available Authors ==\n");
        int i = 0;
        for(String authors : authorsByGenre.get(selectedGenre)){
            System.out.println(i + "." + " " + authors);
            i++;
        }
        System.out.println("\nChoose Your Author: ");
        int selectedAuthor = scan.nextInt();
        for(int j=0; j<authorsByGenre.get(selectedGenre).size(); j++){
            if(authorsByGenre.get(selectedGenre).get(selectedAuthor) == authorsByGenre.get(selectedGenre).get(j)){
                author = authorsByGenre.get(selectedGenre).get(selectedAuthor);
                break;
            }
        }
        chooseBook(scan, author);
    }
    public void chooseBook(Scanner scan, String author){
        List<Book> booksByAuthor = books.stream()
        .filter(b -> b.getAuthor().equals(author) && b.getIsAvailable())
        .collect(Collectors.toList());
        System.out.println("\n== All Available Books ==\n");
        // System.out.println("Name" + "  |  " + "BookID" + "  |  " + "Author" + "  |  " + "Genre");
        for(Book book : booksByAuthor){
            System.out.println(book.getName() + " | " + book.getBookId() + " | " + book.getAuthor() + " | " + book.getGenre());
        }
    }
}
 class Main {
     void main(String[] args){
        BorrowSystem borrowSystem = new BorrowSystem();
        Book[] books = {
            new Book("Dune", "B001", "Science fiction", "Frank Herbert", 12.99),
            new Book("Neuromancer", "B002", "Science fiction", "William Gibson", 10.99),
            new Book("The Left Hand of Darkness", "B003", "Science fiction", "Ursula K. Le Guin", 11.49),

            new Book("The Hobbit", "B004", "Fantasy", "J.R.R. Tolkien", 9.99),
            new Book("A Game of Thrones", "B005", "Fantasy", "George R.R. Martin", 14.99),
            new Book("The Name of the Wind", "B006", "Fantasy", "Patrick Rothfuss", 12.49),

            new Book("Dracula", "B007", "Horror", "Bram Stoker", 8.99),
            new Book("The Shining", "B008", "Horror", "Stephen King", 10.49),
            new Book("Frankenstein", "B009", "Horror", "Mary Shelley", 7.99),

            new Book("The Girl with the Dragon Tattoo", "B010", "Mystery", "Stieg Larsson", 11.99),
            new Book("Gone Girl", "B011", "Mystery", "Gillian Flynn", 12.99),
            new Book("The Da Vinci Code", "B012", "Mystery", "Dan Brown", 13.49),

            new Book("Pride and Prejudice", "B013", "Romance novel", "Jane Austen", 9.49),
            new Book("Outlander", "B014", "Romance novel", "Diana Gabaldon", 10.99),
            new Book("The Notebook", "B015", "Romance novel", "Nicholas Sparks", 8.99),

            new Book("War and Peace", "B016", "Historical fiction", "Leo Tolstoy", 14.99),
            new Book("The Nightingale", "B017", "Historical fiction", "Kristin Hannah", 12.49),
            new Book("All the Light We Cannot See", "B018", "Historical fiction", "Anthony Doerr", 13.99),

            new Book("The Call of the Wild", "B019", "Adventure fiction", "Jack London", 8.49),
            new Book("Treasure Island", "B020", "Adventure fiction", "Robert Louis Stevenson", 9.49),
            new Book("The Lost World", "B021", "Adventure fiction", "Arthur Conan Doyle", 10.49),

            new Book("To Kill a Mockingbird", "B022", "Literary fiction", "Harper Lee", 11.99),
            new Book("The Catcher in the Rye", "B023", "Literary fiction", "J.D. Salinger", 10.99),
            new Book("The Great Gatsby", "B024", "Literary fiction", "F. Scott Fitzgerald", 9.99),

            new Book("The Silence of the Lambs", "B025", "Thriller", "Thomas Harris", 12.99),
            new Book("The Girl on the Train", "B026", "Thriller", "Paula Hawkins", 11.99),
            new Book("The Bourne Identity", "B027", "Thriller", "Robert Ludlum", 10.99),

            new Book("Brave New World", "B028", "Science fiction", "Aldous Huxley", 11.99),
            new Book("Fahrenheit 451", "B029", "Science fiction", "Ray Bradbury", 9.99),
            new Book("The Road", "B030", "Science fiction", "Cormac McCarthy", 10.99),

            new Book("The Way of Kings", "B031", "Fantasy", "Brandon Sanderson", 13.99),
            new Book("Mistborn", "B032", "Fantasy", "Brandon Sanderson", 11.99),
            new Book("The Lies of Locke Lamora", "B033", "Fantasy", "Scott Lynch", 12.49),

            new Book("It", "B034", "Horror", "Stephen King", 12.99),
            new Book("The Exorcist", "B035", "Horror", "William Peter Blatty", 10.49),
            new Book("Pet Sematary", "B036", "Horror", "Stephen King", 11.49),

            new Book("The Hound of the Baskervilles", "B037", "Mystery", "Arthur Conan Doyle", 8.49),
            new Book("And Then There Were None", "B038", "Mystery", "Agatha Christie", 9.99),
            new Book("The Big Sleep", "B039", "Mystery", "Raymond Chandler", 10.49),

            new Book("Jane Eyre", "B040", "Romance novel", "Charlotte Brontë", 9.49),
            new Book("Sense and Sensibility", "B041", "Romance novel", "Jane Austen", 8.99),
            new Book("Me Before You", "B042", "Romance novel", "Jojo Moyes", 11.49),

            new Book("The Book Thief", "B043", "Historical fiction", "Markus Zusak", 12.99),
            new Book("The Pillars of the Earth", "B044", "Historical fiction", "Ken Follett", 13.99),
            new Book("The Help", "B045", "Historical fiction", "Kathryn Stockett", 10.99),

            new Book("Into the Wild", "B046", "Adventure fiction", "Jon Krakauer", 11.49),
            new Book("Life of Pi", "B047", "Adventure fiction", "Yann Martel", 12.49),
            new Book("Around the World in 80 Days", "B048", "Adventure fiction", "Jules Verne", 9.49),

            new Book("1984", "B049", "Literary fiction", "George Orwell", 11.99),
            new Book("Moby Dick", "B050", "Literary fiction", "Herman Melville", 10.49),
            new Book("One Hundred Years of Solitude", "B051", "Literary fiction", "Gabriel García Márquez", 12.99),

            new Book("Shutter Island", "B052", "Thriller", "Dennis Lehane", 11.49),
            new Book("Before I Go to Sleep", "B053", "Thriller", "S.J. Watson", 10.99),
            new Book("The Silence", "B054", "Thriller", "Tim Lebbon", 9.99),

            new Book("Foundation", "B055", "Science fiction", "Isaac Asimov", 13.49),
            new Book("Snow Crash", "B056", "Science fiction", "Neal Stephenson", 12.99),
            new Book("Hyperion", "B057", "Science fiction", "Dan Simmons", 14.99),

            new Book("The Dark Tower: The Gunslinger", "B058", "Fantasy", "Stephen King", 11.99),
            new Book("The Black Prism", "B059", "Fantasy", "Brent Weeks", 10.99),
            new Book("The Last Wish", "B060", "Fantasy", "Andrzej Sapkowski", 12.99),

            new Book("The Haunting of Hill House", "B061", "Horror", "Shirley Jackson", 9.99),
            new Book("House of Leaves", "B062", "Horror", "Mark Z. Danielewski", 12.99),
            new Book("Bird Box", "B063", "Horror", "Josh Malerman", 11.99),

            new Book("Murder on the Orient Express", "B064", "Mystery", "Agatha Christie", 10.49),
            new Book("The Maltese Falcon", "B065", "Mystery", "Dashiell Hammett", 9.49),
            new Book("Big Little Lies", "B066", "Mystery", "Liane Moriarty", 12.49),

            new Book("The Rosie Project", "B067", "Romance novel", "Graeme Simsion", 10.99),
            new Book("Beautiful Disaster", "B068", "Romance novel", "Jamie McGuire", 8.99),
            new Book("Fifty Shades of Grey", "B069", "Romance novel", "E.L. James", 9.49),

            new Book("The Paris Architect", "B070", "Historical fiction", "Charles Belfoure", 11.99)
        };

        for(Book book : books){
            borrowSystem.addBook(book);
        }
        borrowSystem.mainMenu();
    }
}
