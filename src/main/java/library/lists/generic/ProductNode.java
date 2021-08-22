package library.lists.generic;

import java.io.Serializable;

public class ProductNode<T extends Serializable> implements Serializable {
    private ProductNode next;
    private T data;

    public ProductNode() {
        this(null, null);
    }

    public ProductNode(T data) {
        this(null, data);
    }

    public ProductNode(ProductNode next, T data) {
        this.next = next;
        this.data = data;
    }


    public void setNext(ProductNode next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ProductNode<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
