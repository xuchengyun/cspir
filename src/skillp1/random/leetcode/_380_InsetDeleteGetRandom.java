package skillp1.random.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class _380_InsetDeleteGetRandom {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rmd;
    public _380_InsetDeleteGetRandom() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rmd = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
