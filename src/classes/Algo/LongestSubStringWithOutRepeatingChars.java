package classes.Algo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithOutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int start = 0;
        int windowSize = 0;
        int maxLength = 0;
        HashSet<Character> charactersSet = new HashSet<>();

        while (start < s.length()) {
            charactersSet.add(s.charAt(start));
            windowSize = start + 1;
            while (windowSize < s.length())  {
                if (charactersSet.contains(s.charAt(windowSize))) {
                    maxLength = Math.max(charactersSet.size(), maxLength);
                    charactersSet.clear();
                    break;
                } else {
                    charactersSet.add(s.charAt(windowSize));
                    windowSize++;
                }
            }

            if (windowSize >= s.length()) {
                maxLength = Math.max(charactersSet.size(), maxLength);
                charactersSet.clear();
            }
            start++;
        }

        return maxLength;
    }
}
