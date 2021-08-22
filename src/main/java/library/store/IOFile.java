package library.store;

import library.lists.MemberList;
import library.lists.generic.ProductList;
import library.model.Book;
import library.model.Magazine;

import java.io.*;

public class IOFile {

    private static String personFilepath = "C://Users/Asus/Desktop/file.pd";
    private static String BookFilepath = "C://Users/Asus/Desktop/file2.pd";
    private static String magazineFilepath = "C://Users/Asus/Desktop/file3.pd";

    public IOFile() throws IOException {
    }

    public ProductList<Book> readBook() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(BookFilepath))) {
            return (ProductList<Book>) inputStream.readObject();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public ProductList<Magazine> readMagazine() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(magazineFilepath))) {
            return (ProductList<Magazine>) inputStream.readObject();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public MemberList readPerson() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(personFilepath))) {
            return (MemberList) inputStream.readObject();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public void writeBook(ProductList productNode) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(BookFilepath))) {
            outputStream.writeObject(productNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeMagazine(ProductList productNode) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(magazineFilepath))) {
            outputStream.writeObject(productNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writePerson(MemberList productNode) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(personFilepath))) {
            outputStream.writeObject(productNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
