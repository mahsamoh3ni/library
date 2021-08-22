package library.lists;

import library.model.Magazine;
import library.model.Product;

import java.io.Serializable;

public class MagazineList implements ChangeProduct, Serializable {
    private MagazineNode first;

   /* public void addAtFirst(Magazine data) {
        if (first == null)
            first = new MagazineNode(data);
        else {
            MagazineNode MagazineNode = new MagazineNode(data);
            MagazineNode.setNext(first);
            first = MagazineNode;
        }
    }*/

    public void add(Product data) {
        Magazine magazine = (Magazine) data;
        if (first == null)
            first = new MagazineNode(magazine);
        else if (first.getNext() == null) {
            first.setNext(new MagazineNode(magazine));
        } else {
            MagazineNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new MagazineNode(magazine));
        }
    }

    public void viewMagazine() {
        if (first == null)
            System.out.println("Library is empty!");
        MagazineNode current = first;
        while (current != null) {
            current.getData().printInfo();
            current = current.getNext();
        }
    }

    public Magazine findByMagazineNumber(int magazineNUmber) throws Exception {
        MagazineNode current = first;
        while (current != null) {
            if (current.getData().getLibraryId() == magazineNUmber)
                return current.getData();
            current = current.getNext();
        }
        throw new Exception("Magazine not exist!");
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

        MagazineNode current = first.getNext();
        MagazineNode before = first;

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

}
