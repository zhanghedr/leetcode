package com.zhanghedr.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * O(n) time, O(n) space
 * 
 * @author hezha_000
 *
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() > 0) {
                char peek = stack.peek();
                if ((peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.size() == 0;
    }

}
