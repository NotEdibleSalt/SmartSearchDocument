package com.smartsearchdocument.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 6. N 字形变换
 */
@Slf4j
public class T6 {

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下： P   A   H   N A P L S I I G Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数： string convert(string s, int numRows);
     * <p>
     * 示例 1： 输入：s = "PAYPALISHIRING", numRows = 3 输出："PAHNAPLSIIGYIR" 示例 2： 输入：s = "PAYPALISHIRING", numRows = 4 输出："PINALSIGYAHRPI"
     * <p>
     * 解释： P     I    N A   L S  I G Y A   H R P     I
     * <p>
     * 示例 3： 输入：s = "A", numRows = 1 输出："A"
     * <p>
     * 提示： 1 <= s.length <= 1000 s 由英文字母（小写和大写）、',' 和 '.' 组成 1 <= numRows <= 1000
     * <p>
     * 链接：https://leetcode.cn/problems/zigzag-conversio
     */

    public String convert(String s, int numRows) {

        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int height = 1;
        boolean down = true;
        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            rows.get(height - 1)
                .append(c);

            /**
             * 如果是向下，这在高度到达nums时转向
             * 如果是向上，这在高度到达1时转向
             */
            if ((down && height == numRows) || (!down && height == 1)) {
                down = !down;
            }
            if (down) {
                height++;
            } else {
                height--;
            }
        }

       StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i)
                .append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


    @Test
    void test() {

        String s = "AB";
        int numRows = 1;
        String convert = convert(s, numRows);
        System.out.println(convert);
        assert convert.equals("PAHNAPLSIIGYIR");
    }

    @Test
    void test1() {

        System.out.println(1 % 3);
    }
}
