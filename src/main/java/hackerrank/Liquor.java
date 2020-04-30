package hackerrank;

public class Liquor implements VisitableI {
    private double price;

    Liquor(double item) {
        price = item;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(VisitorI visitor) {
        return visitor.visit(this);
    }
}
