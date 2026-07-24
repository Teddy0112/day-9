class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            if (seen[index]) {
                return ch;
            }

            seen[index] = true;
        }

        return ' ';
    }
}
