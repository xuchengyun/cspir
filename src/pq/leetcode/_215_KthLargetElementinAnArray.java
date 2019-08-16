package pq.leetcode;

import java.util.PriorityQueue;

public class _215_KthLargetElementinAnArray {

    // 规定大小
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // nlogk
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
