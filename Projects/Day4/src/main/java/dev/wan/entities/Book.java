package dev.wan.entities;

public class Book {
    // An entity is a class/object that is designed to be saved/persisted somewhere
    // Their job is to hold information
    // The fields in an entity usually have a 1-1 match in a SQL database
    // Entities usually have very little logic in them. Just hold info


    // Should be a Java Bean
    // 1. all fields must be private
    // 2. you must have public getters and setters
    // 3. you need to have a no arguments (You can have more constructors)
    // 4. Technically supposed to implement serializable, but DONT. This is OLD
    //    Deprecated, do NOT serializable
    // Any object NOT a Java Bean is a POJO
    private int bookId; // Primary key
    private String title;
    private String author;
    private int condition; // 1 = like new, 2 = used, 3 = worn, 4 = lost/
    private boolean available; //
    private long dueDate; // epoch
    // Dates are best stored as seconds from Jan 1, 1970 (epoch)


    public Book(){
    }
    public Book(int bookId, String title, String author, int condition, boolean available, long dueDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.available = available;
        this.dueDate = dueDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", condition=" + condition +
                ", available=" + available +
                ", dueDate=" + dueDate +
                '}';
    }
}
