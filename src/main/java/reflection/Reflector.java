package reflection;

public class Reflector {

    int a = 0;
    int b = 0;

    public Reflector (int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int multiply() {
        return a * b;
    }
}
