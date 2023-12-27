public class ListNode {
    // source -> LeetCode
     int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class Solution {
        public static ListNode removeElements(ListNode head, int val) {
            if(head == null) {
                return head;
            }
            ListNode dummy = new ListNode(0); // entirely new LL that will help us iterate thru original
            dummy.next = head;

            ListNode p = dummy;

            while(p!=null && p.next!=null) { //0 1 2 3 6 3 4 5 6
                if(p.next.val==val) {
                    p.next = p.next.next; // change the address of the current node to another address
                } else {
                    p = p.next; // just keep iterating
                }
            }

            return dummy.next;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            ListNode p = head;
            p.next = new ListNode(2);
            p = p.next;
            p.next = new ListNode(6);
            p = p.next;
            p.next = new ListNode(3);
            p = p.next;
            p.next = new ListNode(4);
            p = p.next;
            p.next = new ListNode(5);
            p = p.next;
            p.next = new ListNode(6);

            ListNode start = removeElements(head,6);

            for(ListNode q = start; q!=null; q=q.next) {
                System.out.println(q.val);
            }
        }
}
