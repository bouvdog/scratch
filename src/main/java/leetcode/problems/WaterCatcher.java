package leetcode.problems;

public class WaterCatcher {

    public static int volumneOfWater(int[] struct) {

        int previousHeight = 0;
        int previousLocation = -1;
        int accumulator = 0;
        for (int x = 0; x < struct.length; x++) {
            int height = struct[x];
            if (isVolume(height, x, previousLocation)) {
                accumulator = accumulator + (Math.min(height, previousHeight) * (x - (previousLocation + 1)));
            }
            if (height > 0) {
                previousHeight = height;
                previousLocation = x;
            }
        }
        return  accumulator;
    }

    private static boolean isVolume(int height, int x, int previous) {
        boolean hasVolume = false;
        if (previous < 0) {
            return hasVolume;
        }

        if (height > 0 && x - previous - 1 > 0) {
            hasVolume = true;
        }

        return hasVolume;
    }

}
