import java.util.Scanner;

public class Replace {

    public static Node replaceMethod(Node start, int element, int pos) {

        if (pos == 1) {
            start.data = element;
            return start;
        }

        Node p = start;
        int count = 1;

        while (count <= pos) {

            if (count == pos) {
                p.data = element;
            }
            count++;
            p = p.next;
        }

        return start;
    }

    public static void main(String[] args) {
        Node start = new Node(11);
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of elements you wanna keep: ");
        int n= sc.nextInt();

        System.out.println("Element you want to replace: ");
        int e = sc.nextInt();

        System.out.println("Index: ");
        int index = sc.nextInt();

        Node p = start;
        System.out.println("Before replacing: ");

        for(int i=0; i<n; i++) {
            p.next = new Node(22 + (i*11));
            p = p.next;
            System.out.println(p.data);
        }

        start = replaceMethod(start, e, index);

        System.out.println("After replacing: ");
        for(Node q=start; q!=null; q=q.next) {
            System.out.println(q.data);
        }
    }
}
