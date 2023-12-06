import java.util.Scanner;

public class Deletion {
    // although the deleted element is still there but has no any link from the previous node
    public static Node delete(Node start, int element) {
        if(start.data == element) {
            return start.next;
        }

        Node p = start;
        // 3 4 5 6 7 -> delete 6
        while(p.next != null) {
            if(p.next.data > element) {
                break; // no need to search further considering the array is in sorted order
            }
            if(p.next.data == element) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return start;
    }

    public static void main(String[] args) {
        Node start = new Node(11);

        Node p = start;

        System.out.println("Enter the num you wanna delete: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Before deletion: ");
        System.out.println(p.data);
        for(int i=0; i<4; i++) {
            p.next = new Node(22 + (i*11));
            System.out.println(p.next.data);
            p = p.next;
        }

        start = delete(start, n);

        System.out.println("After deletion: ");

        //  System.out.println(start.data);
        for(Node q=start; q!=null; q=q.next) {

            System.out.println(q.data);
        }
    }

}
