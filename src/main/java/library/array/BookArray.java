package library.array;

import library.model.Book;
import library.lists.ChangeProduct;
import library.model.Product;

public class BookArray implements ChangeProduct {
    private Book[] books;

    public BookArray() {
        this(10);
    }

    public BookArray(int length) {
        books = new Book[length];
    }


    public void add(Product product) {
        Book book = (Book) product;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }

        if (books[books.length - 1] != null) {
            Book[] b = new Book[books.length * 2];

            for (int i = 0; i < books.length; i++)
                b[i] = books[i];

            b[books.length] = book;
            books = b;
        }
    }

    public void viewBooks() throws Exception {
        if (books[0] == null)
            throw new Exception("Library is Empty");

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && !books[i].isDeleted())
                books[i].printInfo();
        }
    }

    public void delete(int id) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId() == id) {
                books[i].setDelete(true);
                break;
            }
        }
    }

    public Book findById(int bookId) throws Exception {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId() == bookId) {
                return books[i];
            }
        }
        throw new Exception("Book not exist!");
    }

    public void addReturnBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }
}
