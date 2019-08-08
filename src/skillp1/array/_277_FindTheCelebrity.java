package skillp1.array;

public class _277_FindTheCelebrity {

    // 找名人
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (res != i && (knows(res, i) || !(knows(i, res)))) {
                return -1;
            }
        }
        return res;
    }

    private boolean knows(int res, int i) {
        return true;
    }
}
