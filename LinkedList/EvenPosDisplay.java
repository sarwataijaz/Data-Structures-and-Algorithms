public class EvenPosDisplay {

    public static void displayEPos(Node start) {

        Node p = start;

        while(p!=null) {
            if(p.data%2 == 0) {
                System.out.println(p.data);
            }
            p = p.next;
        }
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
        System.out.println("Even elements: ");
        displayEPos(start);

        System.out.println("Odd elements: ");
        displayOPos(start);

        System.out.println("Sum: " + sum(start));
    }

    public static void displayOPos(Node start) {

        Node p = start;

        while(p!=null) {
            if(p.data%2 != 0) {
                System.out.println(p.data);
            }
            p = p.next;
        }
    }

    public static int sum(Node start) {

        Node p = start;
        int sum = 0;
        while(p!=null) {
            sum+=p.data;
            p=p.next;
        }

        return sum;
    }
}
