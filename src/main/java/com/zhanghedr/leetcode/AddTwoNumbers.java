package com.zhanghedr.leetcode;

import com.zhanghedr.model.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author hezha_000
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = dummy;
        while (p1 != null || p2 != null) {
            sum /= 10;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if (sum >= 10)
            p.next = new ListNode(1);
        return dummy.next;
    }
}
