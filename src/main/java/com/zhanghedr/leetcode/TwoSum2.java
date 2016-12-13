package com.zhanghedr.leetcode;

/**
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author hezha_000
 *
 */
public class TwoSum2 {

    public int[] twoSum2(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null)
            return indice;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            long v = numbers[left] + numbers[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                return indice;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }
}
