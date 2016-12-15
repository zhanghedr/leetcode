package com.zhanghedr.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author hezha_000
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int sum = 0, i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0) {
            if(i >= 0) sum += a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            sum /= 2;
            i--;
            j--;
        }
        if(sum == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
