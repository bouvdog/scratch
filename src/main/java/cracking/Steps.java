package cracking;

public class Steps {

    public int permutations = 0;

    public void lastStep(int numberOfStairsLeft) {
        if (numberOfStairsLeft >= 3) {
            int setsOfThreeSteps = numberOfStairsLeft / 3;
            int leftOverSteps = numberOfStairsLeft % 3;
            permutations =+ setsOfThreeSteps * 4;
            if (leftOverSteps > 0) {
                lastStep(leftOverSteps);
            }
        } else if (numberOfStairsLeft == 2) {
            permutations =+ 3;
        } else {
            permutations =+ 1;
        }
    }
}
