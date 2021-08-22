package library;

import library.lists.MemberList;
import library.lists.generic.ProductList;
import library.model.*;
import library.store.IOFile;

import java.io.IOException;

public class Library {
    private MemberList memberArray;
    private ProductList<Book> bookArray = new ProductList<>();
    private ProductList<Magazine> magazineArray = new ProductList<>();
    private IOFile ioFile = new IOFile();

    public Library() throws IOException {
        memberArray = new MemberList();
        loadData();
    }

    public void loadData() {
        MemberList memberList = ioFile.readPerson();
        if (memberList != null)
            memberArray = memberList;

        ProductList<Book> list = ioFile.readBook();
        if (list != null)
            this.bookArray = list;

        ProductList<Magazine> magazineProductList = ioFile.readMagazine();
        if (magazineProductList != null)
            this.magazineArray = magazineProductList;
    }

    public void persistData() {
        ioFile.writeBook(bookArray);
        ioFile.writeMagazine(magazineArray);
        ioFile.writePerson(memberArray);
    }

    // ************* Books ************** //


    public void addBook(int bookId,
                        String bookName,
                        int existNumber,
                        ProductType productType,
                        String authorName) throws IOException, ClassNotFoundException {
        Book book = new Book(bookId, bookName, existNumber, productType, authorName);
        bookArray.add(book);
    }

    public void viewProducts() throws Exception {
        bookArray.viewProducts();
    }

    public void deleteBook(int bookId) throws IOException {
        bookArray.delete(bookId);
    }

    public void borrowBook(int userId, int bookId) throws Exception {
        Book book = bookArray.findById(bookId);
        if (book.getExistNumber() > 0) {
            book.setExistNumber(book.getExistNumber() - 1);
            System.out.println("existNumber is:" + book.getExistNumber());
            memberArray.addBorrowedBook(userId, book);
        }
    }

    public void viewBorrowedBook(int userId) {
        memberArray.viewBorrowedBooks(userId);
    }


    public void returnBorrowedBook(int userId, int borrowedBookId) throws Exception {
        Book book = memberArray.returnBorrowedBook(userId, borrowedBookId);
        book.setExistNumber(book.getExistNumber() + 1);
    }


    // *************  magazine ************* //

    public void addNewMagazine(int magazineId,
                               String magazineName,
                               int existNumber2,
                               ProductType productType,
                               int magazineNumber,
                               int day,
                               int month,
                               int year) throws Exception {
        Date date = new Date(day, month, year);
        Magazine magazine = new Magazine(magazineId, magazineName, existNumber2, productType, magazineNumber, date);
        magazineArray.add(magazine);
    }

    public void viewAllMagazine() {
        try {
            magazineArray.viewProducts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void borrowMagazine(int userId, int magazineNumber) throws Exception {
        Magazine magazine = magazineArray.findById(magazineNumber);
        if (magazine.getExistNumber() > 0) {
            memberArray.addBorrowedMagazine(userId, magazine);
            magazine.setExistNumber(magazine.getExistNumber() - 1);
            System.out.println("existNumber is:" + magazine.getExistNumber());
        }
    }

    public void viewBorrowedMagazine(int userId) {
        memberArray.viewBorrowedMagazine(userId);
    }

    public void returnBorrowedMagazine(int userId, int returnMagazineNumber) throws Exception {
        Magazine magazine = memberArray.returnBorrowedMagazine(userId, returnMagazineNumber);
        magazine.setExistNumber(magazine.getExistNumber() + 1);
    }


    // **************** member ************* //

    public void addNewMember(String firstName,
                             String lastName,
                             int nationalCode,
                             int day,
                             int month,
                             int year,
                             String password)
            throws Exception {
        Date date = new Date(day, month, year);
        Member member = new Member(firstName, lastName, nationalCode, date, password);
        memberArray.addMember(member);
    }

    public void viewMember() {
        try {
            memberArray.viewAllMember();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // *********** Check password ******** //

    public boolean checkMember(int userName, String password) throws Exception {
        if (memberArray.checkPassword(userName, password))
            return true;
        else
            throw new Exception("UserName or password invalid!");
    }

   /* public boolean changeManagerPassword(String password, String newPassword) {
        if ()
    }*/
}
