package classes.Algo;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k == 0 || k == nums.length) {
            return;
        }

        if (k > nums.length) {
            k = k % nums.length;
        }

        int elementsReachedItsCorrectPosition = 0;
        for (int i = 0; i < k && elementsReachedItsCorrectPosition < nums.length; i++) {
            int index = i;
            int element = nums[index];
            while (true) {
                int positionToAppend = index + k >= nums.length ? (index + k) % nums.length : index + k;
                int temp = nums[positionToAppend];
                nums[positionToAppend] = element;
                elementsReachedItsCorrectPosition++;
                if (positionToAppend == i) {
                    break;
                }

                element = temp;
                index = positionToAppend;
            }
        }
    }


}
