package library.lists;

import library.model.Book;

import library.model.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookListTest {
    private BookList bookList = new BookList();
    private MemberList memberList = new MemberList();

    @Test
    void add_and_get_should_successfully() throws Exception {
        Book book = new Book(1, "alaki", 10, ProductType.History, "loli");
        bookList.add(book);


        Book book1 = bookList.findById(1);
        Assertions.assertThat(book1.getName()).isEqualTo(book.getName());
        Assertions.assertThat(book1.getAuthor()).isEqualTo(book.getAuthor());
    }

    @Test
    void several_multi_add_and_get_should_successfully() throws Exception {
        Book book = new Book(1, "alaki", 10, ProductType.History, "loli");
        Book book2 = new Book(2, "alaki1", 11, ProductType.Romance, "loli2");
        Book book3 = new Book(3, "alaki2", 12, ProductType.Educational, "loli3");

        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);

        Book bookId = bookList.findById(1);
        Book bookId2 = bookList.findById(2);
        Book bookId3 = bookList.findById(3);
        Assertions.assertThat(bookId.getName()).isEqualTo(book.getName());
        Assertions.assertThat(bookId2.getName()).isEqualTo(book2.getName());
        Assertions.assertThat(bookId3.getName()).isEqualTo(book3.getName());
    }

    @Test
    void several_multi_add_and_remove_from_middle() throws Exception {
        Book book = new Book(1, "alaki", 10, ProductType.History, "loli");
        Book book2 = new Book(2, "alaki1", 11, ProductType.Romance, "loli2");
        Book book3 = new Book(3, "alaki2", 12, ProductType.Educational, "loli3");
        Book book4 = new Book(4, "alaki4", 12, ProductType.Educational, "loli4");

        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        bookList.delete(2);

        assertThrows(Exception.class, () -> bookList.findById(2));
    }

    @Test
    void several_multi_add_and_remove_from_end() throws Exception {
        Book book = new Book(1, "alaki", 10, ProductType.History, "loli");
        Book book2 = new Book(2, "alaki1", 11, ProductType.Romance, "loli2");
        Book book3 = new Book(3, "alaki2", 12, ProductType.Educational, "loli3");
        Book book4 = new Book(4, "alaki4", 12, ProductType.Educational, "loli4");

        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        bookList.delete(4);

        assertThrows(Exception.class, () -> bookList.findById(4));
    }

    @Test
    void several_multi_add_and_remove_from_first() throws Exception {
        Book book = new Book(1, "alaki", 10, ProductType.History, "loli");
        Book book2 = new Book(2, "alaki1", 11, ProductType.Romance, "loli2");
        Book book3 = new Book(3, "alaki2", 12, ProductType.Educational, "loli3");
        Book book4 = new Book(4, "alaki4", 12, ProductType.Educational, "loli4");

        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        bookList.delete(1);
        assertThrows(Exception.class, () -> bookList.findById(1));
    }


}