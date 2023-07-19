package com.smartsearchdocument.leetcode;

import cn.hutool.json.JSONUtil;
import com.mysql.cj.log.Log;
import java.math.BigInteger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

/**
 * 2. 两数相加 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。 请你将两个数相加，并以相同形式返回一个表示和的链表。 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例 1： 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
 * <p>
 * 示例 2： 输入：l1 = [0], l2 = [0] 输出：[0]
 * <p>
 * 示例 3： 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示： 每个链表中的节点数在范围 [1, 100] 内 0 <= Node.val <= 9 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/add-two-numbers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class T2 {

    @Data
    public class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode buildListNode(BigInteger num) {

        if (num.intValue() < 10) {
            return new ListNode(num.intValue());
        }

        ListNode listNode = new ListNode(num.mod(BigInteger.valueOf(10L)).intValue());
        num = num.divide(BigInteger.valueOf(10));
        listNode.next = buildListNode(num);
        return listNode;
    }


    public int[] add(ListNode l1, ListNode l2, int carryNum){

        if (l1 == null && l2 == null && carryNum == 0){
            return new int[]{0, 0};
        }

        int i = carryNum;
        if (l1 != null){
            i = i + l1.val;
        }
        if (l2 != null){
            i = i + l2.val;
        }


        int num;
        if (i > 9) {
            carryNum = 1;
            num = i - 10;
        } else {
            carryNum = 0;
            num = i;
        }
        return new int[]{num, carryNum};
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carryNum = 0;
        int num = 0;

        ListNode result = new ListNode(num);
        ListNode cur = result;

        while (l1 != null || l2 != null) {

            int i = carryNum;
            if (l1 != null){
                i = i + l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                i = i + l2.val;
                l2 = l2.next;
            }


            if (i > 9) {
                carryNum = 1;
                num = i - 10;
            } else {
                carryNum = 0;
                num = i;
            }

            cur.next = new ListNode(num);
            cur = cur.next;
        }

        if(carryNum == 1) {
            cur.next = new ListNode(carryNum);
        }

        return result.next;
    }

    @Test
    void test(){

        ListNode l1 = buildListNode(BigInteger.valueOf(41));
        ListNode l2 = buildListNode(BigInteger.valueOf(20));

        ListNode listNode = addTwoNumbers(l1, l2);
        log.info(JSONUtil.toJsonPrettyStr(listNode));

    }
}
