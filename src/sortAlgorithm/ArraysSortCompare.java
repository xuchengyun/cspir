package sortAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCompare {

    class Interval {
        int start;
        int end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void test(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
    }

    public static void main(String[] args) {

    }
}
