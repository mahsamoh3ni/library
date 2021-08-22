package library.lists;

import library.model.Member;

import java.io.Serializable;

public class MemberNode implements Serializable {
    private MemberNode next;
    private Member data;

    public MemberNode() {
        this(null, null);
    }

    public MemberNode(Member data) {
        this(null, data);
    }

    public MemberNode(MemberNode next, Member data) {
        this.data = data;
        this.next = next;
    }

    public void setNext(MemberNode next) {
        this.next = next;
    }

    public void setData(Member data) {
        this.data = data;
    }

    public Member getData() {
        return data;
    }

    public MemberNode getNext() {
        return next;
    }
}
