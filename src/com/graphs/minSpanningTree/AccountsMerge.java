package com.graphs.minSpanningTree;

import java.util.*;

/**
 * GFG
 * https://www.geeksforgeeks.org/problems/account-merge/1
 */
public class AccountsMerge {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> mailMapNode = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                // if mail is not mapped put it into map
                // else merge the node with its parent node
                if (!mailMapNode.containsKey(mail)) {
                    mailMapNode.put(mail, i);
                } else {
                    ds.union(i, mailMapNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMails = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMails[i] = new ArrayList<>();
        }

        // now find ultimate parent of each mail from map and put back to merged mail
        for (Map.Entry<String, Integer> it : mailMapNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUltimateParent(it.getValue());
            mergedMails[node].add(mail);
        }

        // build answer
        List<List<String>> mail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMails[i].size() == 0) {
                continue;
            }
            Collections.sort(mergedMails[i]);
            List<String> temp = new ArrayList<>();
            // get name of person
            temp.add(accounts.get(i).get(0));
            for (String mails : mergedMails[i]) {
                temp.add(mails);
            }
            mail.add(temp);
        }
        return mail;
    }

    static class DisjointSet {
        public List<Integer> parents = new ArrayList<>();
        public List<Integer> size = new ArrayList<>();

        DisjointSet(int v) {
            for (int i = 0; i <= v; i++) {
                parents.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node) {
            if (parents.get(node) == node) {
                return node;
            }
            int ultParent = findUltimateParent(parents.get(node));
            parents.set(node, ultParent);
            return parents.get(node);
        }

        void union(int u, int v) {
            int ultParU = findUltimateParent(u);
            int ultParV = findUltimateParent(v);

            if (ultParV == ultParU) {
                return;
            }

            if (ultParU < ultParV) {
                parents.set(ultParU, ultParV);
                int newSize = size.get(ultParU) + size.get(ultParV);
                size.set(ultParV, newSize);
            } else {
                parents.set(ultParV, ultParU);
                int newSize = size.get(ultParU) + size.get(ultParV);
                size.set(ultParU, newSize);
            }
        }
    }
}
