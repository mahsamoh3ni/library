package library.array;

import library.model.Magazine;
import library.model.Product;

public class MagazineArray  {
    private Magazine[] magazines;

    public MagazineArray() {
        this(10);
    }

    public MagazineArray(int length) {
        magazines = new Magazine[length];
    }

    public Magazine getMagazine(int length) {
        return magazines[length];
    }


    public void add(Product product) {
        Magazine magazine = (Magazine) product;
        for (int i = 0; i < magazines.length; i++) {
            if (magazines[i] == null) {
                magazines[i] = magazine;
                break;
            }
        }
        if (magazines[magazines.length - 1] != null) {
            Magazine[] m = new Magazine[magazines.length * 2];
            for (int i = 0; i < magazines.length; i++) {
                m[i] = magazines[i];

                m[magazines.length] = magazine;
                magazines = m;

            }
        }
    }

    public void viewMagazine() throws Exception {
        if (magazines[0] == null)
            throw new Exception("Library is Empty!");

        for (int i = 0; i < magazines.length; i++) {
            if (magazines[i] != null) {
                magazines[i].printInfo();
            }
        }
    }

    public Magazine findByMagazineNumber(int magazineNumber) {
        for (int i = 0; i < magazines.length; i++) {
            if (magazines[i] != null && magazines[i].getMagazineNumber() == magazineNumber) {
                return magazines[i];
            }
        }
        return null;
    }

    public void addReturnMagazine(Magazine magazine) {
        for (int i = 0; i < magazines.length; i++) {
            if (magazines[i] == null) {
                magazines[i] = magazine;
                break;
            }
        }
    }
}
