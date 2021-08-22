package library.model;

public class Magazine extends Product {
    private Date date;
    private int magazineNumber;
    private static int magazineCounter = 1;


    public Magazine(int magazineId, String name, double number, ProductType productType, int magazineNumber, Date date) {
        super(name, number, productType, magazineId, magazineCounter++);
        this.magazineNumber = magazineNumber;
        this.date = date;
    }

    public void setMagazineNumber(int magazineNumber) {
        this.magazineNumber = magazineNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getMagazineNumber() {
        return magazineNumber;
    }


    @Override
    public String toString() {
        return "\n" + super.toString() + "\n" + "Date is:" + date + "\n" + "MagazineNumber is:" + magazineNumber + "\n";
    }

}
