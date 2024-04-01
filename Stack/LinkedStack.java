
public class LinkedStack implements Stack {
    Nodee top;
    int size = 0;
    public static StackBasic<Object> arrayStackObj(LinkedStack stack) {
        StackBasic<Object> arrayStack = new StackBasic<>(stack.getSize());

        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            arrayStack.push(obj);
        }
        return arrayStack;
    }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public Object peek() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty.");
            }
            return top.data;
        }

        @Override
        public void push(Object obj) {
            top = new Nodee(obj, top);
            ++size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public Object pop() {
            Object temp = top.data;
            top = top.next;
            --size;
            return temp;
        }


    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(2);
        stack.push(5);
        stack.push(45);
        stack.push(56);
        stack.push(234);

        StackBasic<Object> arrayStack = arrayStackObj(stack);
        arrayStack.display();
    }
}
