package arraysandstrings;

import java.util.Arrays;

public class Deduplicator {

    private static int visited = 0;

    public static void main(String[] args) {
        char[] chars = args[0].toCharArray();
        deduplicate(chars);
        System.out.println(Arrays.toString(chars));
    }

    private static void deduplicate(char[] s) {
        int oldStrPos = 0;
        int newStrPos = 0;

        while (oldStrPos < s.length) {
            char c = s[oldStrPos];
            if (markAsVisited(c)) {
                oldStrPos++;
            } else {
                s[newStrPos++] = s[oldStrPos++];
            }
        }

        // cleaning unused positions
        for (int i = newStrPos; i < s.length; i++) {
            s[i] = 0;
        }
    }

    private static boolean markAsVisited(char c) {
        int cBit = 1 << (c - 'a');
        if ((cBit & visited) != 0) {
            // already visited
            return true;
        } else {
            // was not visited before
            visited |= cBit;
            return false;
        }
    }
}
