public class AddTwoNumbers {
        /*
        题目：2. 两数相加
        描述：给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
        链接：https://leetcode.cn/problems/add-two-numbers/description/
        难度：中等
        思路：执一carry，从头到尾
        时间：2025年4月16日21:50:05
     */

    public static void main(String[] args) {
        AddTwoNumbers numbers = new AddTwoNumbers();
        System.out.println();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(), head = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remain = l2 == null ? l1 : l2;
        while (remain != null) {
            int sum = remain.val + carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
            remain = remain.next;
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
