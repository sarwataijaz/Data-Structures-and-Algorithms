public class Node {

    int data;
    Node next;

    Node(int data) { // for simple initialization
        this.data = data;
    }
    Node(int data, Node next) { // for insertion and deletion in order to keep track of next node
        this.data = data;
        this.next = next; // the next node to point/link to
    }
}
