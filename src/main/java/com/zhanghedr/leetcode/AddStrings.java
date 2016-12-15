package com.zhanghedr.leetcode;

/**
 * Given two non-negative numbers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * @author hezha_000
 *
 */
public class AddStrings {
    public String addStrings(String a, String b) {
        if (a == null || b == null)
            return "";
        StringBuilder sb = new StringBuilder();
        int sum = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';
            sb.append(sum % 10);
            sum /= 10;
            i--;
            j--;
        }
        if (sum == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
