package library.lists;

import library.model.Magazine;

import java.io.Serializable;

public class MagazineNode implements Serializable {
    private MagazineNode next;
    private Magazine data;

    public MagazineNode() {
        this(null, null);
    }

    public MagazineNode(Magazine data) {
        this(null, data);
    }

    public MagazineNode(MagazineNode next, Magazine data) {
        this.data = data;
        this.next = next;
    }

    public void setNext(MagazineNode next) {
        this.next = next;
    }

    public void setData(Magazine data) {
        this.data = data;
    }

    public MagazineNode getNext() {
        return next;
    }

    public Magazine getData() {
        return data;
    }
}
