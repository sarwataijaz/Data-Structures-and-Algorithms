import java.util.Scanner;

public class Search {

    public static boolean searchMethod(Node start, int n) {

        Node p = start;
        while(p!=null) {
            if(p.data == n) {
                return true;
            }
            p=p.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node start = new Node(11);
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of elements you wanna keep: ");
        int n= sc.nextInt();

        Node p = start;
        for(int i=0; i<n; i++) {
            p.next = new Node(22 + (i*11));
            p = p.next;
        }

        System.out.println("Element you want to search: ");
        int e = sc.nextInt();

        System.out.println(searchMethod(start, e));
    }
}
