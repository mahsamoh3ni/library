package library.model;


import library.lists.BookList;
import library.lists.MagazineList;

public class Member extends Person {
    private int userId;
    private static int count = 0;

    private BookList borrowBooks = new BookList();
    private MagazineList borrowMagazines = new MagazineList();


    public Member(String firstName, String lastName, int nationalCode, Date birthday, String password) {
        super(firstName, lastName, nationalCode, birthday, password);
        userId = ++count;
    }

    public static int getCount() {
        return count;
    }

    public int getUserId() {
        return userId;
    }

    public BookList getBorrowBooks() {
        return borrowBooks;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + "\n" + "UserName is:" + userId + "\n";
    }

    public void print() {
        System.out.println(this.toString());
    }

    public void addBorrowedBook(Book book) {
        borrowBooks.add(book);
    }

    public void viewBorrowedBook() {
        borrowBooks.viewBooks();
    }

    public void addBorrowedMagazine(Magazine magazine) {
        borrowMagazines.add(magazine);
    }

    public void viewBorrowedMagazine() {
        borrowMagazines.viewMagazine();
    }

    public Book findByBookId(int borrowBookId) throws Exception {
        Book book = borrowBooks.findById(borrowBookId);
        borrowBooks.delete(borrowBookId);
        return book;
    }

    public Magazine findByMagazineNumber(int magazineNumber) throws Exception {
        Magazine magazine = borrowMagazines.findByMagazineNumber(magazineNumber);
        borrowMagazines.delete(magazineNumber);
        return magazine;
    }
}
