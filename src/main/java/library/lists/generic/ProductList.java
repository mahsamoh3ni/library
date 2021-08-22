package library.lists.generic;

import library.model.Product;
import library.store.IOFile;

import java.io.IOException;
import java.io.Serializable;


public class ProductList<T extends Product> implements GenericChangeProduct<T>, Serializable {
    private ProductNode<T> first;


    public ProductList() throws IOException {
    }

    public void add(T data) throws IOException, ClassNotFoundException {
        if (isEmpty()) {
            first = new ProductNode<T>(data);


        } else if (first.getNext() == null) {
            first.setNext(new ProductNode<T>(data));


        } else {
            ProductNode<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ProductNode<T>(data));

        }
    }

    public void viewProducts() throws IOException, ClassNotFoundException {
        ProductNode<T> current = first;
        if (isEmpty())
            System.out.println("Library is empty");

        while (current != null) {
            current.getData().printInfo();
            current = current.getNext();
        }
    }

    public void delete(int libraryId) throws IOException {
        if (isEmpty()) {
            System.out.println("Library is empty!");
            return;
        }

        if (first.getData().getLibraryId() == libraryId) {
            deleteFromFirst();
            return;
        }

        ProductNode<T> current = first.getNext();
        ProductNode<T> before = first;

        while (current.getNext() != null) {
            if (current.getData().getLibraryId() == libraryId) {
                before.setNext(current.getNext());
                return;
            }

            before = current;
            current = current.getNext();
        }

        if (current.getData().getLibraryId() == libraryId) {
            before.setNext(null);
        }
    }

    public T findById(int libraryId) throws Exception {
        ProductNode<T> current = first;
        while (current != null) {
            if (current.getData().getLibraryId() == libraryId)
                return current.getData();
            current = current.getNext();
        }
        throw new Exception("Book not exist!");
    }

    private void deleteFromFirst() {
        first = first.getNext();
    }

    private boolean isEmpty() {
        return first == null;
    }
}
