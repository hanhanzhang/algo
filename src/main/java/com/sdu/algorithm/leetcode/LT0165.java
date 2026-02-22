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

public class LT0165 {

    private static int compareVersion(String version1, String version2) {
        int c1 = 0, n1 = version1.length(), c2 = 0, n2 = version2.length();
        while (c1 < n1 || c2 < n2) {
            int s1 = c1, s2 = c2;
            while (c1 < n1 && version1.charAt(c1) != '.')
                c1 += 1;
            while (c2 < n2 && version2.charAt(c2) != '.')
                c2 += 1;

            int v1 = 0, v2 = 0;
            if (s1 < n1) {
                v1 = Integer.parseInt(version1.substring(s1, c1));
                c1 += 1;
            }
            if (s2 < n2) {
                v2 = Integer.parseInt(version2.substring(s2, c2));
                c2 += 1;
            }

            if (v1 < v2)
                return -1;
            if (v1 > v2)
                return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
    }

}
