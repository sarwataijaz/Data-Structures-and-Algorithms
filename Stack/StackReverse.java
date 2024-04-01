public class StackReverse {
    public static Nodee reverse(Nodee start) {
        Nodee p = start;
        Nodee prev = null;
        Nodee next = null;
        while(p!=null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return start;
    }

    public static void main(String[] args) {
        Nodee start = new Nodee(1);
        Nodee p=start;
        for(int i=2; i<=5; i++) {
            p.next = new Nodee(i);
        }
        Nodee ex = reverse(start);

        for(Nodee q=ex; q!=null; q=q.next) {
            System.out.println(q.data);
        }

    }
}
