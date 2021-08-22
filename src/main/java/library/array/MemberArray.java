package library.array;

import library.model.Book;
import library.model.Magazine;
import library.model.Member;

public class MemberArray {
    private Member[] members;

    public MemberArray() {
        this(10);
    }

    public MemberArray(int length) {
        members = new Member[length];
    }

    public Member getMember(int length) {
        return members[length];
    }

    public int getLength() {
        return members.length;
    }

    public void addMember(Member member) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                members[i] = member;
                System.out.println(members[i].toString());
                break;
            }
        }
        if (members[members.length - 1] != null) {
            Member[] m = new Member[members.length * 2];
            for (int i = 0; i < members.length; i++) {
                m[i] = members[i];

                m[i] = member;
                members = m;
            }
        }
    }

    public void viewAllMember() throws Exception {
        if (members[0] == null)
            throw new Exception("Empty member");

        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) {
                members[i].print();
            }
        }
    }


    public boolean checkPassword(int userName, String password) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].getUserId() == userName && members[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addBorrowedBook(int userId, Book borrowedBook) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].getUserId() == userId) {
                members[i].addBorrowedBook(borrowedBook);
            }
        }
    }

    public void viewBorrowedBooks(int userId) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].getUserId() == userId)
                members[i].viewBorrowedBook();
        }
    }

    public void addBorrowedMagazine(int userId, Magazine magazine) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].getUserId() == userId) {
                members[i].addBorrowedMagazine(magazine);
            }
        }
    }

    public void viewBorrowedMagazine(int userId) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].getUserId() == userId) {
                members[i].viewBorrowedMagazine();
            }
        }
    }

    public Book returnBorrowedBook(int userId, int borrowedBookId) throws Exception{
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].getUserId() == userId) {
                return members[i].findByBookId(borrowedBookId);

            }
        }
        return null;
    }

//    public Magazine returnBorrowedMagazine(int userId, int borrowedMagazineNumber) {
//        for (int i = 0; i < members.length; i++) {
//            if (members[i] != null && members[i].getUserId() == userId) {
//                return members[i].findByMagazineNumber(borrowedMagazineNumber);
//            }
//        }
//        return null;
//    }

}
