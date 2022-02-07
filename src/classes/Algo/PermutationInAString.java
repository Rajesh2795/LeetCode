package classes.Algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInAString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int count = s1Map.getOrDefault(c, 0);
            s1Map.put(c, ++count);
        }

        for (int i = 0; i < s2.length(); i++) {

            //check if starting character contains in permutation.
            // If not skip the current character;
            if (!s1Map.containsKey(s2.charAt(i))) {
                continue;
            }

            //Character is present in the permutation
            //From current position to current + s1.length will become the window size
            int windowSize = s1.length();
            int start = i;
            int to = i + windowSize;

            // Traverse until the window size and check if it contains all chars.
            // If not break from the loop
            // Repeat the process from i + 1;
            Map<Character, Integer> charactersCount = new HashMap<>();
            while (to <= s2.length() && start < to) {
                char ch = s2.charAt(start);
                if (!s1Map.containsKey(ch)) {
                    break;
                }

                int count = charactersCount.getOrDefault(ch, 0);
                charactersCount.put(ch, ++count);

                start++;
            }

            if (start == to) {
                // If permutation is found then return true
                boolean isPermutationPresent = s1Map.size() == charactersCount.size();

                for (Character key : charactersCount.keySet()) {
                    if (!s1Map.containsKey(key) || !Objects.equals(s1Map.get(key), charactersCount.get(key))) {
                        isPermutationPresent = false;
                        break;
                    }
                }

                if (isPermutationPresent) {
                    return true;
                }
            }
        }

        return false;
    }
}
