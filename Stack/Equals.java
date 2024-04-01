public class Equals {
    public static void main(String[] args) {
        StackBasic<Integer> arrStack = new StackBasic<>(5);
        arrStack.push(3);
        arrStack.push(4);
        arrStack.push(5);
        arrStack.push(2);
        arrStack.push(1);

        LinkedStack llStack = new LinkedStack();
        llStack.push(3);
        llStack.push(4);
        llStack.push(5);
        llStack.push(1);
        llStack.push(1);

        System.out.println(compare(arrStack,llStack));

    }
    public static boolean compare(StackBasic arrStack, LinkedStack llStack) {
        int size;
        if(arrStack.size<llStack.size) {
            size = arrStack.size;
        } else {
            size = llStack.size;
        }

        for(int i=0; i<size; i++) {
            if(arrStack.pop() != llStack.pop())
                return false;
        }
        return true;
    }
}
