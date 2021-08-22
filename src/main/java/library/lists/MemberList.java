package library.lists;

import library.model.Book;
import library.model.Magazine;
import library.model.Member;

import java.io.Serializable;

public class MemberList implements Serializable {
    private MemberNode first;

    public void addMember(Member data) {
        MemberNode memberNode;
        if (first == null) {
            first = new MemberNode(data);
            memberNode = first;
        } else {
            memberNode = new MemberNode(data);
            memberNode.setNext(first);
            first = memberNode;
        }
        System.out.println(memberNode.getData().toString());
    }

    public void viewAllMember() {
        MemberNode current = first;
        if (first == null)
            System.out.println("Member not exist!");
        while (current != null) {
            current.getData().print();
            current = current.getNext();
        }
    }

    public boolean checkPassword(int userName, String password) {
        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userName && current.getData().getPassword().equals(password))
                return true;
            current = current.getNext();
        }
        return false;
    }

    public void viewBorrowedBooks(int userId) {
        if (first == null) {
            System.out.println("List is Empty!");
            return;
        }

        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userId)
                current.getData().viewBorrowedBook();
            current = current.getNext();
        }
    }

    public void viewBorrowedMagazine(int userId) {
        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userId)
                current.getData().viewBorrowedMagazine();
            current = current.getNext();
        }
    }

    public void addBorrowedMagazine(int userId, Magazine magazine) {
        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userId)
                current.getData().addBorrowedMagazine(magazine);
            current = current.getNext();
        }
    }

    public void addBorrowedBook(int userId, Book borrowedBook) {
        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userId)
                current.getData().addBorrowedBook(borrowedBook);
            current = current.getNext();
        }
    }

    public Book returnBorrowedBook(int userId, int borrowedBookId) throws Exception {
        if (first == null)
            System.out.println("Book not exist!");
        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userId)
                return current.getData().findByBookId(borrowedBookId);
            current = current.getNext();
        }
        return null;
    }

    public Magazine returnBorrowedMagazine(int userId, int borrowedMagazineNumber) throws Exception {
        if (first == null)
            System.out.println("Book not exist!");
        MemberNode current = first;
        while (current != null) {
            if (current.getData().getUserId() == userId)
                return current.getData().findByMagazineNumber(borrowedMagazineNumber);
            current = current.getNext();
        }
        return null;
    }
}


