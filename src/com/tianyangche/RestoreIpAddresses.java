package com.tianyangche;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     *
     * Example:
     *
     * Input: "25525511135"
     * Output: ["255.255.11.135", "255.255.111.35"]
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(res, s, new ArrayList<>());
        return res;
    }

    private void dfs(List<String> res, String s, List<String> curr) {
        if (s.isEmpty()) {
            if (curr.size() == 4) {
                res.add(convertToValidIpAddress(curr));
            }
            return;
        }
        if (s.length() < 4 - curr.size() || s.length() > 3 * (4 - curr.size())) {
            return;
        }
        for (int i = 0; i < Math.min(s.length(), 3); i++) {
            String temp = s.substring(0, i + 1);
            if (isValid(temp)) {
                curr.add(temp);
                dfs(res, s.substring(i + 1), curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isValid(String temp) {
        int value = Integer.valueOf(temp);
        if ((value == 0 && temp.length() > 1) || (value != 0 && temp.charAt(0) == '0') || (value > 255)) {
            return false;
        }
        return true;
    }

    private String convertToValidIpAddress(List<String> curr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curr.size(); i++) {
            sb.append(curr.get(i)).append('.');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
