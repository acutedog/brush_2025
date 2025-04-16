import java.util.List;
import java.util.SplittableRandom;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int[] nums) {
        ListNode dummy = new ListNode(), head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        this.val = nums[0];
        this.next = dummy.next.next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode reverse() {
        if (next == null) {
            return this;
        }
        ListNode pre = null, cur = this;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    void print() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        ListNode nums = new ListNode(new int[] {2,4,3});
        nums.print();
        ListNode reverse = nums.reverse();
        reverse.print();
    }
}
