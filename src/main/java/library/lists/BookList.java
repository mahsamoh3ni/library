package library.lists;

import library.model.Book;
import library.model.Product;

import java.io.Serializable;


public class BookList implements ChangeProduct, Serializable {

    private BookNode first;

    public void add(Product data) {
        Book book = (Book) data;
        if (first == null)
            first = new BookNode(book);
        else if (first.getNext() == null) {
            first.setNext(new BookNode(book));
        } else {
            BookNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new BookNode(book));
        }
    }

    public void viewBooks() {
        BookNode current = first;
        if (first == null) {
            System.out.println("Library is empty");
        }
        while (current != null) {
            current.getData().printInfo();
            current = current.getNext();
        }
    }


    private void deleteFromFirst() {
        first = first.getNext();
    }

    public void delete(int data) {
        if (first == null) {
            System.out.println("Library is empty!");
            return;
        }

        if (first.getData().getLibraryId() == data) {
            deleteFromFirst();
            return;
        }

        BookNode current = first.getNext();
        BookNode before = first;

        while (current.getNext() != null) {
            if (current.getData().getLibraryId() == data) {
                before.setNext(current.getNext());
                return;
            }

            before = current;
            current = current.getNext();
        }

        if (current.getData().getLibraryId() == data) {
            before.setNext(null);
        }
    }

    public Book findById(int bookId) throws Exception {
        BookNode current = first;
        while (current != null) {
            if (current.getData().getLibraryId() == bookId)
                return current.getData();
            current = current.getNext();
        }
        throw new Exception("Book not exist!");
    }
}
