import java.util.Arrays;

public class MergeSort{

    public int[] sort(int[] arr){
        int length = arr.length;
        
        if (length <= 1){
            return arr;
        }

        int mid = Math.floorDiv(length, 2);
        int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, length);
        return merge(sort(leftArray), sort(rightArray));
    }

    public int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int leftPos = 0;
        int rightPos = 0;
        int currentIndex = 0;
        while (leftPos < left.length && rightPos < right.length){
            if (left[leftPos] < right[rightPos]){
                merged[currentIndex] = left[leftPos];
                leftPos++;
            }
            else{
                merged[currentIndex] = right[rightPos];
                rightPos++;
            }
            currentIndex++;
        }
        System.arraycopy(left, leftPos, merged, currentIndex, left.length - leftPos);
        System.arraycopy(right, rightPos, merged, currentIndex,right.length - rightPos);
        return merged;
    }

    public static void main (String[] args) {
        int[] inputArr = {3, 5, 2, 90, 4, 7};
        MergeSort sorter = new MergeSort();
        System.out.println(Arrays.toString(sorter.sort(inputArr)));
    }
}