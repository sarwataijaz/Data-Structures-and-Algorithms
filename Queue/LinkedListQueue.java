class Node {
    Object data;
    Node next = this;
    Node prev = this;

    public Node(Object obj) {
        data = obj;
    }
    public Node(Object obj, Node p, Node n) {
        data = obj;
        next = n;
        prev = p;
    }
}

interface Queue {
    public Object remove();
    public void add(Object obj);
    public Object first();
    public int getSize();
}
public class LinkedListQueue implements Queue {

    private int size = 0;
    Node head = new Node(null);
    @Override
    public Object remove() {
        Object temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        --size;

        return temp;
    }

    @Override
    public void add(Object obj) {

        head.prev.next = new Node(obj,head.prev, head);  // h 1 2 3 4
        head.prev = head.prev.next;
        ++size;
    }

    @Override
    public Object first() {
        if(size==0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return head.next.data;
    }

    @Override
    public int getSize() {
        if(size==0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return size;
    }

    public Object last() {
        if(size==0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return head.prev.data;
    }

    void print() {
        Node p = head.next;

        while (p != null && p != head) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    void reverse() {
       Node next = null;
       Node current = head.next; //
       Node prev = null ;
       // 1,2,3,4
       while(current != head) {
           next = current.next; //
           current.next = prev ; //
           prev = current ; //
           current = next ; //
       }

    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        for(int i=1;i<=5; i++) {
            queue.add(i);
        }
//        System.out.println(queue.first());
//        System.out.println(queue.last());
//        System.out.println(queue.getSize());

        queue.print();
        queue.reverse();
        queue.print();

    }
    // binary tree (including AVL and BST)
}
