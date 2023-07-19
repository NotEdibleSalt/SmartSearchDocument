package com.smartsearchdocument.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 7. 整数反转
 */
public class T7 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 如果反转后整数超过 32 位的有符号整数的范围，就返回 0。 假设环境不允许存储 64 位整数（有符号或无符号）。
     * <p>
     * 示例 1： 输入：x = 123 输出：321
     * <p>
     * 示例 2： 输入：x = -123 输出：-321
     * <p>
     * 示例 3： 输入：x = 120 输出：21
     * <p>
     * 示例 4： 输入：x = 0 输出：0
     * <p>
     * 提示： -231 <= x <= 231 - 1
     * <p>
     * 链接：https://leetcode.cn/problems/reverse-integer
     */
    public int reverse(int x) {

        int result = 0;
        int b;
        while (x != 0) {

            b = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && b > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && b < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            //判断条件不满足的时候才进行计算
            result = result * 10 + b;
            //继续倒着取下一位
            x = x / 10;
        }
        return result;
    }

    @Test
    void test() {

        System.out.println(-3 / 10);
    }

}
