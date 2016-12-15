package com.zhanghedr.leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author hezha_000
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            if (sum < 10)
                return digits;
            else
                carry = 1;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++)
                res[i] = digits[i - 1];
            return res;
        } else {
            return digits;
        }
    }
}
