package skillp1.binarysearch.leetcode;

public class _279_FirstBadVersion {
    public int firstBadVersion (int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
