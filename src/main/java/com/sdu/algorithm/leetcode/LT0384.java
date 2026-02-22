/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sdu.algorithm.leetcode;

import java.util.Random;

public class LT0384 {

    static class Solution {

        private int[] origin;
        private int[] array;

        private Random rand = new Random();

        public Solution(int[] nums) {
            this.array = nums;
            this.origin = nums.clone();

        }

        public int[] reset() {
            array = origin;
            origin = origin.clone();
            return array;
        }

        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public int[] shuffle() {
            for (int i = 0; i < array.length; ++i) {
                swapAt(i, randRange(i, array.length));
            }
            return array;
        }
    }

    public static void main(String[] args) {

    }

}
