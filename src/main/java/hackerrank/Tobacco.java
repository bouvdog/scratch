package hackerrank;

public class Tobacco implements VisitableI {
    private double price;

    Tobacco(double item) {
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
