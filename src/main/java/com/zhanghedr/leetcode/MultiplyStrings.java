package com.zhanghedr.leetcode;

/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative. Converting
 * the input string to integer is NOT allowed. You should NOT use internal
 * library such as BigInteger.
 * 
 * @author hezha_000
 *
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty())
            return "";
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int carry = 0;
            int aInt = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int bInt = num2.charAt(j) - '0';
                int product = aInt * bInt + carry;
                pos[i + j + 1] += product % 10;
                carry = product / 10;
            }
            if (carry != 0)
                pos[i] += carry;
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = pos.length - 1; i >= 0; i--) {
            pos[i] += carry;
            carry = pos[i] / 10;
            if (i != 0 || (i == 0 && pos[i] != 0))
                sb.append(pos[i] % 10);
        }
        return sb.reverse().toString();
    }
}
