package com.zhanghedr.leetcode;

import java.util.Stack;

import com.zhanghedr.model.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * most significant digit comes first and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words,
 * reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 
 * @author hezha_000
 *
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                stack1.push(p1.val);
                p1 = p1.next;
            }
            if (p2 != null) {
                stack2.push(p2.val);
                p2 = p2.next;
            }
        }
        ListNode p = new ListNode(0);
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty())
                sum += stack1.pop();
            if (!stack2.isEmpty())
                sum += stack2.pop();
            p.val = sum % 10;
            sum /= 10;
            ListNode node = new ListNode(sum);
            node.next = p;
            p = node;
        }
        return sum == 0 ? p.next : p;
    }
}
