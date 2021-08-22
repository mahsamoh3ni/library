package library.model;

public class Book extends Product {
    private String author;
    private boolean delete = false;
    private static int bookCounter = 1;

    public Book(int bookId, String name, double number, ProductType productType, String author) {
        super(name, number, productType, bookId, bookCounter++);
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDeleted() {
        return delete;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Author is:" + author + "\n";
    }
}
