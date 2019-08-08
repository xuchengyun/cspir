package skillp1.bitmanipulation.xor;

public class _389_FindTheDIfference {

    public int findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
