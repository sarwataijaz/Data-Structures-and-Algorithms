import java.util.ArrayList;

public class StackUsingArrayList implements Stack {
    ArrayList<Object> list;

    StackUsingArrayList() {
        list = new ArrayList<>();
    }
    @Override
    public Object peek() {
        if(list.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return list.get(list.size()-1);
    }

    @Override
    public void push(Object obj) {
        list.add(obj);
    }

    @Override
    public Object pop() {
        if(list.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return list.remove(list.size()-1);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
