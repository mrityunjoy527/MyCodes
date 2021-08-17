package hash;

import java.util.Objects;

public class HashCodeAndEquals {

    public static void main(String[] args) {

        Pen pen1 = new Pen(10, "blue");
        Pen pen2 = new Pen(10, "blue");

        System.out.print(pen1.equals(pen2));
    }
}
class Pen {
    int price;
    String colour;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price && Objects.equals(colour, pen.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, colour);
    }

    public Pen(int price, String colour){
        this.price = price;
        this.colour = colour;
    }

}
