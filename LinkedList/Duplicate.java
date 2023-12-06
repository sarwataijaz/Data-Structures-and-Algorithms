import java.util.Scanner;

public class Duplicate {

    public static boolean findDuplicate(Node start) {

        // 2 3 4 4 5 6 7

        Node p = start;
        while(p.next!=null) {

            if(p.data == p.next.data) { // assuming the list is in ascending order
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node start = new Node(2);
        System.out.println("Enter 5 elements: ");
        Scanner sc = new Scanner(System.in);

        Node p = start;
        for(int i=0; i<5; i++) {
            int input = sc.nextInt();
            p = new Node(input);
            p = p.next;
        }
        System.out.println("Occurence of a duplicate element: " + findDuplicate(start));
    }
}
