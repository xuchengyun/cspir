package p1.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.remove(2);
        System.out.println(Arrays.toString(arrayList.toArray()) + arrayList.size());
        int[] nums = new int[] {1,2,3,4,5};
        Arrays.sort(nums);
    }
}
