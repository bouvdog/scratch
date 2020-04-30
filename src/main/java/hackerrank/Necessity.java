package hackerrank;

public class Necessity implements VisitableI {
    private double price;

    Necessity(double item) {
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
