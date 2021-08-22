package library.lists;

import library.model.Book;

import java.io.Serializable;

public class BookNode implements Serializable {
    private BookNode next;
    private Book data;

    public BookNode() {
        this(null, null);
    }

    public BookNode(Book data) {
        this(null, data);
    }

    public BookNode(BookNode next, Book data) {
        this.next = next;
        this.data = data;
    }



    public void setNext(BookNode next) {
        this.next = next;
    }

    public void setData(Book data) {
        this.data = data;
    }

    public BookNode getNext() {
        return next;
    }

    public Book getData() {
        return data;
    }
}
