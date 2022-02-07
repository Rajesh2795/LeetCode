package classes.Algo;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int lastZeroFound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastZeroFound++] = nums[i];
            }
        }

        if (lastZeroFound != 0 && lastZeroFound < nums.length) {
            while (lastZeroFound < nums.length) {
                nums[lastZeroFound++] = 0;
            }
        }

        System.out.println("After moving elements: " + Arrays.toString(nums));

        /*int noOfZeros = 0;
        for (int num : nums) {
            if (num == 0) noOfZeros++;
        }

        if (noOfZeros == 0) return;

        int nextAvailableIndex = 0;
        int noOfElements = nums.length - noOfZeros;
        int i = 0;
        while (noOfElements > 0) {
            int element = nums[i++];
            if (element != 0) {
                nums[nextAvailableIndex++] = element;
                noOfElements--;
            }
        }

        while (noOfZeros > 0) {
            nums[nextAvailableIndex++] = 0;
            noOfZeros--;
        }*/
    }
}
