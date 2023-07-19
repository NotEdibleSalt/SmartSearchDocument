package com.smartsearchdocument.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class T4 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数 。 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 示例 1： 输入：nums1 = [1,3], nums2 = [2] 输出：2.00000 解释：合并数组 = [1,2,3] ，中位数 2
     * <p>
     * 示例 2： 输入：nums1 = [1,2], nums2 = [3,4] 输出：2.50000 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 提示： nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1 <= m + n <= 2000 -106 <= nums1[i], nums2[i] <= 106
     * <p>
     * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;

        int remainder = totalLength % 2;
        int div = totalLength / 2;

        int[] pos = new int[]{-1, -1};
        if (remainder == 0) {
            pos[0] = div;
            pos[1] = div + 1;
        } else {
            pos[0] = div + 1;
        }

        int[] nums = new int[div + 1];
        int curPos = 0;
        int length1Pos = 0;
        int length2Pos = 0;

        while ((length1 > length1Pos || length2 > length2Pos) && curPos < Math.max(pos[0], pos[1])) {

            if (length1 <= length1Pos) {
                nums[curPos] = nums2[length2Pos];
                length2Pos++;
                curPos++;
                continue;
            }

            if (length2 <= length2Pos) {
                nums[curPos] = nums1[length1Pos];
                length1Pos++;
                curPos++;
                continue;
            }

            if (nums1[length1Pos] < nums2[length2Pos]) {

                nums[curPos] = nums1[length1Pos];
                length1Pos++;
            } else {
                nums[curPos] = nums2[length2Pos];
                length2Pos++;
            }

            curPos++;
        }

        if (pos[1] != -1){

            return ((double) nums[pos[0] - 1] + (double)nums[pos[1] - 1]) / 2;
        }

        return nums[pos[0] - 1];
    }

    @Test
    void test() {

        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{1, 2, 3};

        double arrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(arrays);
    }

    /**
     这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n))，看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。
     那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。
     这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定，因此需要分情况来讨论，
     对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。
     为了简化代码，不分情况讨论，我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。
     加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。

     这里我们需要定义一个函数来在两个有序数组中找到第K个元素，
     下面重点来看如何实现找到第K个元素。首先，为了避免产生新的数组从而增加时间复杂度，我们使用两个变量i和j分别来标记数组nums1和nums2的起始位置。
     然后来处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，
     那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。还有就是如果K=1的话，那么我们只要比较nums1和nums2的起始位置i和j上的数字就可以了。
     难点就在于一般的情况怎么处理？因为我们需要在两个有序数组中找到第K个元素，为了加快搜索的速度，我们要使用二分法，
     对K二分，意思是我们需要分别在nums1和nums2中查找第K/2个元素，
     注意这里由于两个数组的长度不定，所以有可能某个数组没有第K/2个数字，所以我们需要先检查一下，数组中到底存不存在第K/2个数字，
     如果存在就取出来，否则就赋值上一个整型最大值。如果某个数组没有第K/2个数字，那么我们就淘汰另一个数字的前K/2个数字即可。
     有没有可能两个数组都不存在第K/2个数字呢，这道题里是不可能的，因为我们的K不是任意给的，而是给的m+n的中间值，所以必定至少会有一个数组是存在第K/2个数字的。
     最后就是二分法的核心啦，比较这两个数组的第K/2小的数字midVal1和midVal2的大小，如果第一个数组的第K/2个数字小的话
     ，那么说明我们要找的数字肯定不在nums1中的前K/2个数字，所以我们可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。
     反之，我们淘汰nums2中的前K/2个数字，并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归即可。
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }

}

