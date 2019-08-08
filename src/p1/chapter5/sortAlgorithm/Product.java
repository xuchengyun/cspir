package p1.chapter5.sortAlgorithm;

import java.util.Comparator;

public class Product implements Comparable<Product>{
    private int price;
    private int sale;

    public Product(int price, int sale) {
        this.price = price;
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sale=" + sale +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.sale == o.sale) {
            return this.price - o.price;
        } else {
            return this.sale - o.sale;
        }
    }
}

class ProductCompare implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }
}
