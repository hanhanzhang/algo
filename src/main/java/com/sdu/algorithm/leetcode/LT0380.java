package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LT0380 {

    class RandomizedSet {

        // key: val, value: index
        private final Map<Integer, Integer> map = new HashMap<>();
        private final List<Integer> list = new ArrayList<>();
        private final Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int last = list.get(list.size() - 1);
            int index = map.get(val);
            map.put(last, index);
            list.set(index, last);

            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
