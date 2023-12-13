public class Reverse {

    public static Node reverse(Node start) {

        Node p = start;
        int tempArr[];
        // 1 2 3 4 5
        int size = 0;
        while(p != null) {
            size++;
            p = p.next;
        }
        tempArr = new int[size];
        p = start;

        int i=0;
        while(p.next != null) {
            tempArr[i] = p.data;
            p = p.next;
            i++;
        }

//         start.data = tempArr[size-1];
         p = start;
        for(int j=size-1; j>=0; j--) {
            p.data = tempArr[j];
            p = p.next;
        }

        return start;
    }
    public static void main(String[] args) {
        Node start = new Node(0);

        Node p = start;
        System.out.println("Original LinkedList: ");
        for(int i=1; i<=20; i++) {
            p.next = new Node(i);
            p = p.next;
            System.out.println(p.data);
        }
        System.out.println("After reversing: ");

        start = reverse(start);

        for(Node q = start; q!=null; q=q.next) {
            System.out.println(q.data);
        }
    }
}
