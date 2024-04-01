import org.w3c.dom.traversal.NodeFilter;
// h.w -> implement shuffling
// make a linkedstack method which returns an arraystack object (copy it to arraystack)
// add and text a toString method in both array and LL stack
// add and test a equals method in array and LL stack (whether both data is arranged and is same)
// add and test a method for array and LL, that removes the element in bottom and is returned
public class Nodee {
    Nodee next;
    Object data;

    Nodee(Object data, Nodee next) {
        this.data = data;
        this.next = next;
    }
    Nodee(Object data) {
        this.data = data;
    }
}
    class LinkedListStack<T> {

        private Nodee top;
        private Nodee last;
        private int size;

        public Object peek() {
            return top.data;
        } //3
        public void push(Object obj) {
            if(top==null) {

            }
            top = new Nodee(obj, top);
            ++size;
        }

        public T pop() {
            Object temp = top.data;
            top = top.next;
            return (T)temp;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return(size==0);
        }

        public boolean search(T obj) {
            Nodee p = top;

            while(p!=null) {
                if(p.data==obj) {
                    return true;
                }
                p=p.next;
            }
            return false;
        }
        public Object[] toArrayStack() {
            Nodee p = top;
            Object[] arr;
            int arrSize = 0;
            while (p != null) {
                arrSize++;
                p = p.next;
            }
            arr = new Object[arrSize];
            p = top;
            int i = 0;
            while (p != null) {
                arr[i] = p.data;
                i++;
                p = p.next;
            }
            return arr;
        }

        public void display() {
            for(Nodee p=top; p!=null; p=p.next) {
                System.out.println(p.data);
            }
        }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        Object arr[] = stack.toArrayStack();
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
