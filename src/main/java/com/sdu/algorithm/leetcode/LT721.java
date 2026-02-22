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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT721 {

    private static boolean checkSamePerson(Set<String> s1, Set<String> s2) {
        Set<String> ps1, ps2;

        if (s1.size() < s2.size()) {
            ps1 = s1;
            ps2 = s2;
        } else {
            ps1 = s2;
            ps2 = s1;
        }

        for (String email : ps1) {
            if (ps2.contains(email)) {
                return true;
            }
        }

        return false;
    }

    private static Set<String> dfs(Map<Integer, String> posToNames,
                                   Map<Integer, Set<String>> posToEmails, Set<Integer> chains, int k) {
        chains.add(k);

        Set<String> curEmails = posToEmails.get(k);

        Set<String> ans = new HashSet<>(curEmails);
        for (int i = 0; i < posToNames.size(); ++i) {
            if (chains.contains(i)) {
                continue;
            }

            Set<String> emails = posToEmails.get(i);

            if (checkSamePerson(curEmails, emails)) {
                chains.add(i);
                ans.addAll(emails);
                ans.addAll(dfs(posToNames, posToEmails, chains, i));
            }
        }

        return ans;
    }

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, Set<String>> posToEmails = new HashMap<>();
        Map<Integer, String> posToNames = new HashMap<>();
        int pos = 0;
        for (List<String> account : accounts) {
            Iterator<String> it = account.iterator();
            posToNames.put(pos, it.next());
            Set<String> emails = new HashSet<>();
            while (it.hasNext()) {
                emails.add(it.next());
            }
            posToEmails.put(pos, emails);
            ++pos;
        }

        List<List<String>> ans = new LinkedList<>();
        Set<Integer> chains = new HashSet<>();
        for (int i = 0; i < accounts.size(); ++i) {
            if (chains.contains(i)) {
                continue;
            }
            List<String> res = new LinkedList<>();
            res.add(posToNames.get(i));
            List<String> mergeEmails = new ArrayList<>(dfs(posToNames, posToEmails, chains, i));
            Collections.sort(mergeEmails);
            res.addAll(mergeEmails);

            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));

        System.out.println(accountsMerge(accounts));
    }

}
