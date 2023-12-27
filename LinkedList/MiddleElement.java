public class MiddleElement {

    // source -> leetcode
        public ListNode deleteMiddle(ListNode head) {

            if(head == null) {
                return head;
            }
            ListNode p=head;
            int size=0;

            while(p!=null) {
                size++;
                p=p.next;
            }

            int midIndex = size/2;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;

            int count=0;
            while(current!=null && current.next!=null) {

                if(count == midIndex) {
                    current.next = current.next.next;
                    break;
                } else {
                    current=current.next;
                }
                count++;
            }
            return dummy.next;
        }
}
