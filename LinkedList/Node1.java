import java.util.Scanner;

public class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node1 start = new Node1(11); // first element
        Node1 p = start;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to enter in a LinkedList: ");
        int n = sc.nextInt();

        System.out.println(p.data);
        for(int i=0; i<n; i++) { // p.next-> address of where the next node is stored, p.next.data -> value
            p.next = new Node1(22 + (11*i)); // we are setting links to the next nodes
            System.out.println(p.next.data);
            p = p.next; // works in a way -> p++
        }
        System.out.println("Number of elements displayed: ");
    }
}
