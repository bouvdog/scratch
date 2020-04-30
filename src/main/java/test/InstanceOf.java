package test;

public class InstanceOf {
    public static void main(String[] args) throws Exception {
        B b = new B();

        if (b instanceof InstanceOf) {
            System.out.println("yes");
        }

        System.out.println(b.power(3, 5));
        System.out.println(b.power(-1, -2));
    }
}

class  B extends InstanceOf {
    public int divide(int a, int b) {
        int c = -1;

        try {
            c = a / b;
        }
        catch (Exception e) {
            System.err.print("Exception ");
        }
        finally {
            System.err.println("Finally ");
        }

        return c;
    }

    public int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative.");
        } else {
            return (int) Math.pow((double)n, (double)p);
        }
    }

}