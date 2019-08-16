package design;

import java.util.PriorityQueue;

public class _295_FindMedianFromDataStream {

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public _295_FindMedianFromDataStream() {
        this.large = new PriorityQueue<>();
        this.small = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());
        if (large.size() < small.size()) {
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        return  large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
    }
}
