package library.model;

import java.io.Serializable;

abstract public class Product implements Serializable {
    private String name;
    private double existNumber;
    private ProductType productType;
    private int id;
    private int libraryId;

    public Product(String name, double existNumber, ProductType productType, int id, int libraryId) {
        this.name = name;
        this.existNumber = existNumber;
        this.productType = productType;
        this.id = id;
        this.libraryId = libraryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExistNumber(double existNumber) {
        this.existNumber = existNumber;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getExistNumber() {
        return existNumber;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getId() {
        return id;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public boolean isExist() {
//        if (existNumber > 0)
//            return true;
//        else return false;

        return existNumber > 0;
    }

    @Override
    public String toString() {
        return "name is:" + name + "\n" +
                "number is:" + existNumber + "\n" +
                "Grouping is:" + productType + "\n" +
                "Id is:" + id + "\n" +
                "ExistNumber is:" + existNumber + "\n" +
                "LibraryId is:" + libraryId + "\n";
    }

    public void printInfo() {
        System.out.println(toString() + "\n");
    }
}
