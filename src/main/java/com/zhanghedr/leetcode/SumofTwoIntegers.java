package com.zhanghedr.leetcode;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * @author hezha_000
 *
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        int sum = 0, carry = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = (a & 1) + (b & 1) + carry;
            carry = bitSum / 2;
            sum += ((bitSum % 2) << i);
            a >>>= 1;
            b >>>= 1;
        }
        return sum;
    }
}
