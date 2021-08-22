package library.array;

import library.model.Book;
import library.model.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookArrayTest {
    private BookArray books = new BookArray(5);

    @Test
    void add_and_get_should_successfully() throws Exception {
        Book book = new Book(1,"alaki",10, ProductType.History, "loli");
        books.add(book);

        Book booksById = books.findById(1);

        Assertions.assertThat(booksById.getName()).isEqualTo(book.getName());
    }

    @Test
    void delete_should_be_successfully() {

        Book book = new Book(1,"alaki",10, ProductType.History, "loli");
        Book book2 = new Book(2,"alaki",10, ProductType.History, "loli");
        Book book3 = new Book(3,"alaki",10, ProductType.History, "loli");
        books.add(book);
        books.add(book2);
        books.add(book3);

        books.delete(3);
        Assertions.assertThat(book3.isDeleted()).isEqualTo(true);
    }

    @Test
    void should_throw_exception_if_book_not_exist() {
        assertThrows(Exception.class, () -> books.findById(10));
    }
}