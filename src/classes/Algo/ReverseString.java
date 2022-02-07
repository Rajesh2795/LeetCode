package classes.Algo;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s.length == 1) {
            return;
        }

        int left = 0, right = s.length - 1;
        while (left < right) {
           if (s[left] != s[right]) {
               swap(s, left, right);
           }
           left++;
           right--;
        }
    }

    public void swap(char[] arr, int from, int to) {
        if (from == to) return;

        char temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public void printArgument(int number) {
        System.out.println(number);
    }
}
