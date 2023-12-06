public class LinkedListEx {

    int data;
    LinkedListEx next;

    LinkedListEx(int data) { this.data = data; }

    public static void main(String[] args) {
        LinkedListEx linkedList = new LinkedListEx(11);
        linkedList.next = new LinkedListEx(12);
        linkedList.next.next = new LinkedListEx(13);

        System.out.println(linkedList.data);
        System.out.println(linkedList.next.data);
        System.out.println(linkedList.next.next.data);
    }
}
