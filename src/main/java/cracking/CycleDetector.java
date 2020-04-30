package cracking;

public class CycleDetector {

    public static boolean hazCycle(int[] arr) {
        int p = 0;
        int q = 0;
        while (true) {
            if (noCycle(p, q, arr.length)) {
                return false;
            }
            p = arr[p];
            if (p == q) {
                return true;
            }
            if (noCycle(p, q, arr.length)) {
                return false;
            }
            p = arr[p];
            if (p == q) {
                return true;
            }
            q = arr[q];
            if (p == q) {
                return true;
            }
        }
    }

    static boolean noCycle(int p, int q, int length) {
        if (p < 0 || q < 0 || p >= length || q >= length) {
            return true;
        } else {
            return false;
        }
    }
}
