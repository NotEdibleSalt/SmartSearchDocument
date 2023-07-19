package com.smartsearchdocument.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 5. 最长回文子串
 */
public class T5 {


    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * <p>
     * 示例 1： 输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2： 输入：s = "cbbd" 输出："bb"
     * <p>
     * 提示： 1 <= s.length <= 1000 s 仅由数字和英文字母组成 链接：https://leetcode.cn/problems/longest-palindromic-substring
     */
    public String longestPalindrome(String s) {

        if (isPalindrome(s)) {
            return s;
        }
        String longestStr = "";

        int length = s.length();
        for (int i = 0; i < length; i++) {

            for (int j = length; j > i; j--) {
                String str = s.substring(i, j);
                if (isPalindrome(str)) {
                    if (longestStr.length() < str.length()) {
                        longestStr = str;
                    }
                }
                if (longestStr.length() > j - i) {
                    break;
                }
            }
            if (longestStr.length() > length - i) {
                break;
            }
        }

        return longestStr;
    }

    public boolean isPalindrome(String str) {

        int length = str.length();
        if (length == 1) {
            return true;
        }

        for (int i = 0; i < length / 2; i++) {

            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {

        String str = longestPalindrome("babad");
        System.out.println(str);
        assert isPalindrome(str);
    }


    public String dynamic(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

}
