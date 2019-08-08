package amazon;

import java.util.Random;

public class _973_KCLosetPointstoOrigin {
    private Random random = new Random();
    public int[][] kClosest(int[][] points, int k) {
        int start = 0, end = points.length - 1;
        int index = 0;
        while (start <= end) {
            index = partition(points, start, end);
            if (index == k) {
                break;
            }
            if (index > k) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        int[][] res = new int[index][2];
        for (int i = 0; i < index; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int partition(int[][] points, int start, int end) {
        int pivotIdx = start + random.nextInt(end - start + 1);
        int[] pivotPoint = points[pivotIdx];
        swap(points, pivotIdx, end);
        int left = start, right = end - 1;
        while (left <= right) {
            while (left <= right && compare(points[end], points[left]) >= 0) {
                left++;
            }
            while (left <= right &&compare(points[right], points[end]) >= 0) {
                right--;
            }
            if (left <= right && compare(points[left], points[end]) > 0 && compare(points[end], points[right]) > 0) {
                swap(points, left++, right--);
            }
        }
        swap(points, left, end);
        return left;
    }

    private void swap(int[][] points, int i1, int i2) {
        int[] temp = points[i1];
        points[i1] = points[i2];
        points[i2] = temp;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    public static void main(String[] args) {
    int[][] test = new int[][] {{0, 1}, {1, 0}};
        _973_KCLosetPointstoOrigin k = new _973_KCLosetPointstoOrigin();
        k.kClosest(test, 2);
    }
}
