public class ListToArr {

    public static int[] LinkedListToArray(Node start) {
        // first triverse the LL to determine the size
        int arr[];
        Node p = start;
        int size = 0;
        while(p!=null) {
            size++;
            p = p.next;
        }
        arr = new int[size];

         p = start;
        for(int i=0; i<size; i++) {
            arr[i] = p.data;
            p=p.next;
        }

        return arr;
    }
    public static void main(String[] args) {
        Node start = new Node(0);

        Node p = start;
        System.out.println("Original LinkedList: ");
        for(int i=1; i<=10; i++) {
            p.next = new Node(i);
            p = p.next;
            System.out.println(p.data);
        }
        int arr[] = LinkedListToArray(start);
        System.out.println("Linkedlist to array: ");
        for(int i=0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Array to LinkedList: ");
        Node start2 = ArrayToLinkedList(arr);

    for(Node q=start2; q!=null; q=q.next) {
            System.out.println(q.data);
        }
    }
    public static Node ArrayToLinkedList(int[] arr) {
        Node start = new Node(arr[0]);

        Node p = start;
        for(int i=1; i< arr.length; i++) {
            p.next = new Node(arr[i]); // move to the next node and assign value
            p=p.next; // point to the newly created node
        }
        return start;
    }
}
