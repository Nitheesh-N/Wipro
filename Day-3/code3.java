public class Main {

    public static void main(String[] args) {
        Book b1 = new Book();
           System.out.println("Book 1:");
           b1.displayInfo();
        Book b2 = new Book("Java Programming", "Sakshi", 2024);
        System.out.println("Book 2:");
        b2.displayInfo();
 
    }
    static class Book {
        String title;
        String author;
        int year;
        public Book() {
            title = "Not specified";
            author = "Unknown";
            year  = 0;
        }
        public Book(String title,String author,int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println();
    }
    }
}