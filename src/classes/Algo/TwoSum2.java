package classes.Algo;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return numbers;
        }

        int right = numbers.length -1;
       /* while (numbers[--right] > target);*/

        int left = 0;
        int[] result = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }

            if (target - numbers[right] < numbers[left]) {
                right--;
            } else if (target - numbers[left] > numbers[right]) {
                left++;
            }
        }

        return result;
    }
}
