import org.junit.jupiter.api.Test;

public class TestSortingCracking {

    // 10.1
    @Test
    public void testMergeTwo() {
        Integer[] a = new Integer[10];
        Integer[] b = new Integer[5];

        for (int i = 0; i < 10; i++) {
            a[i] = i;
            b[i] = i*2;
        }

       for (int i=0;i<10;i++) {
           // move A's elements to the end of the array
           a[i + 5] = a[i];
           a[i] = 0;
       }
       for (int i=0;i<10;i++) {
           if (a[i+5] <= b[i]) {
               a[i] = a[i+5];
           }
       }
    }
}
