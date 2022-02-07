package classes.Algo;

import java.util.Arrays;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s.length() == 1) {
            return s.trim();
        }

        String[] stringsArr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = stringsArr.length - 1; i >= 0; i--) {
            String string = stringsArr[i];
            if (string.isEmpty() || string.equals(" ")) continue;
            else {
                builder.append(string);
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public void swap(char[] arr, int from, int to) {
        if (from == to) return;

        char temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public String reverseWords1(String s) {
        if (s.length() == 1) {
            return s.trim();
        }

        //convert to char array
        char[] charArr = s.toCharArray();

        //reverse all chars
        int left = 0, right = charArr.length - 1;

        while (left < right) {
            if (charArr[left] != charArr[right]) {
                swap(charArr, left, right);
            }

            left++;
            right--;
        }

        // After reversing all chars
        // Start from left go to right
        // if right encounters a space that means it a word.
        // Then append all chars to builder.
        StringBuilder builder = new StringBuilder();
        int start = 0, end = 0;

        while (end < charArr.length) {
            if (charArr[end] == ' ') {
                while (end < charArr.length && charArr[end] == ' ') {
                    end++;
                }

                start = end;
            }

            if (start < charArr.length) {
                while (end < charArr.length && Character.isLetterOrDigit(charArr[end])) {
                    end++;
                }

                int k = end - 1;
                while (k >= start) {
                    builder.append(charArr[k]);
                    k--;
                }

                builder.append(' ');
                start = end;
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public void reverse(char[] s, int from, int to) {
        if (from == to) return;
        int left = from, right = to;
        while (left < right) {
            if (s[left] != s[right]) {
                swap(s, left, right);
            }

            left++;
            right--;
        }
    }

    public void reverseWordsInString2(char[] s) {
        if (s.length == 1) {
            return;
        }

        //reverse all chars
        reverse(s, 0, s.length - 1);
        System.out.println("after reverse: " + Arrays.toString(s));

        // Now reverse individual words with in the array.
        int left = 0, right = 0;
        while (right < s.length) {
            while (right < s.length && Character.isLetterOrDigit(s[right])) {
                right++;
            }

            reverse(s, left, right - 1);

            right++;
            left = right;
        }
    }
}
