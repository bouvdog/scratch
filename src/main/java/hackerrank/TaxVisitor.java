package hackerrank;

import java.text.DecimalFormat;

public class TaxVisitor implements VisitorI {

    DecimalFormat df = new DecimalFormat("#.##");

    public TaxVisitor() {}

    @Override
    public double visit(Liquor liquorItem) {
        System.out.println("Liquor item: price with Tax");
        return Double.parseDouble(df.format((liquorItem.getPrice() * .18) + liquorItem.getPrice()));
    }

    @Override
    public double visit(Tobacco tobaccoItem) {
        System.out.println("Tobacco item: price with Tax");
        return Double.parseDouble(df.format((tobaccoItem.getPrice() * .32) + tobaccoItem.getPrice()));
    }

    @Override
    public double visit(Necessity necessityItem) {
        System.out.println("Necessity item: price with Tax");
        return Double.parseDouble(df.format((necessityItem.getPrice()*0) + necessityItem.getPrice()));
    }
}
