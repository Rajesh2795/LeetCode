package classes;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.length() == 1 && t.length() == 1) {
            return s.equals(t) ? s : "";
        }
        if (s.equals(t)) return s;

        int[] sChars = new int[256];
        int[] tChars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i)]++;
        }

        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (tChars[s.charAt(i)] > 0) {
                sChars[s.charAt(i)]--;
                if (sChars[s.charAt(i)] < tChars[s.charAt(i)]) {
                    startIndex = i;
                    break;
                }
            } else {
                sChars[s.charAt(i)]--;
            }
        }

        int endIndex = s.length() - 1;
        while (endIndex > startIndex) {
            if (tChars[s.charAt(endIndex)] > 0) {
                sChars[s.charAt(endIndex)]--;
                if (sChars[s.charAt(endIndex)] < tChars[s.charAt(endIndex)]) {
                    break;
                }
            } else {
                endIndex--;
            }
        }

        return "";




    }
}
