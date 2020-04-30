package cracking;

public class QSort {
    public static void quicksort(Integer[] array, Integer left, Integer right) {
        int index = youTubePartition(array, left, right);
            if (left < index - 1) {
                // sort left half
                quicksort(array, left, index - 1);
            }
            if (index < right) {
                quicksort(array, index, right);
            }
        }

        static Integer partition(Integer[] array, Integer left, Integer right) {

        // pivot selection can have a large effect on the performance
        Integer pivot = array[left + (right-left)/2];

        while (left <= right) {

            // Find an element on the left that should be on the right of the pivot
            while (array[left] < pivot) {
                left++;
            }

            // Find and element on the right that should be on the left of the pivot
            while (array[right] > pivot) {
                right--;
            }

            // swap elements and move left and right indices
            if (left <= right) {
                Integer temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }
        }
        return left;
    }

    public static void youTubeQSort(Integer[] array, Integer left, Integer right) {
        Integer index = youTubePartition(array, left, right);
        if (left < index - 1){
            youTubeQSort(array, left, index - 1);
        }

  //      if (index < right) {
  //          youTubeQSort(array, index, right);
  //      }

    }

    // it is assumed that right is the index of the 'end' of the array
    public static int youTubePartition(Integer[] array, Integer left, Integer right) {
        // pivot selection can have a large effect on the performance
        Integer pivot = array[left + (right-left)/2];

        // swap pivot and end element of the array
        array[left + (right - left) / 2] = array[right];
        array[right] = pivot;
        Integer pivotIndex = right;

        right--;
        while (right > left) {

            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;

            if (right < left) {
                // Done, swap pivot back in
                array[pivotIndex] = array[left];
                array[left] = pivot;
            } else {
                // swap left and right
                Integer temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return left;
    }
}
