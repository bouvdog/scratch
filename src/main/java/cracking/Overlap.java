package cracking;

public class Overlap {

    // Data format: eight element array. 0: left bottom x, 1: left bottom y, 2: right top x, 3: right top y
    // The second rectangle is the same format as the first
    // This is scoped to two rectangles
    // Returns zero if rectangles do not overlap
    // Returns positive area if they do
    public static int rectangleOverlap(int[] twoRectangles) {
        int y = 0;
        int x = 0;
        x = distance(twoRectangles[0], twoRectangles[4], twoRectangles[2], twoRectangles[6]);
        y = distance(twoRectangles[1], twoRectangles[5], twoRectangles[3], twoRectangles[7]);
        return x*y;
    }

    static int distance(int a, int b, int c, int d) {
        return Math.min(c, d) - Math.max(a, b);
    }
}
