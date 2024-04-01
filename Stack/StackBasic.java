// stack implementation using Arrays.
interface Stack {
    public int getSize();
    public Object peek();
    public void push(Object obj);
    public Object pop();
}
public class StackBasic<T> {
    Object[] arr;
    public int size = 0;
    StackBasic(int capacity) {
        arr = new Object[capacity];
    }
    public T peek() {
       if(size == 0) { // thru size variable we can track how many elements have been stored in a stack
           throw new IllegalStateException("Stack is empty.");
       }

       return (T)arr[size-1];
    }

    public void push(T obj) {

        if(size == arr.length) {
            resize();
        }
        arr[size++] = obj;

    }

    public void resize() {
        Object[] temp = arr;
        arr = new Object[2*temp.length]; // twice the size of the original array.
        System.arraycopy(temp,0,arr,0,size);
    }
    private boolean isEmpty() {
        return(size==0);
    }

    public T pop() {
        if(size == 0) { // thru size variable we can track how many elements have been stored in a stack
            throw new IllegalStateException("Stack is empty.");
        }
        Object temp = arr[--size];
        arr[size] = null;
        return (T)temp; // return the deleted element.
    }

    public boolean search(T value) {
        for(int i=0; i<size; i++) {
            if(arr[i] == value)
                return true;
        }
        return false;
    }
    public void display() {
        for(int i=0; i<size; i++) {
            System.out.println(arr[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public Object[] getArrayOfStack(){
        return arr;
    }

    public static void main(String[] args) {
        StackBasic<String> coldrink = new StackBasic(3);
        coldrink.push("Pepsi");
        coldrink.push("Marinda");
        coldrink.push("Dew");
        coldrink.push("colacola");
        coldrink.push("fanta");


        StackBasic fruits = new StackBasic(3);
        coldrink.push("Strawberry");
        coldrink.push("Cheeku");
        coldrink.push("Banana");
        coldrink.push("Apple");
        coldrink.push("Orange");

//     method1(coldrink,fruits);
//     method2(coldrink,fruits);
        mergeStack(coldrink,fruits);

    }

    public static void method1(StackBasic coldrink, StackBasic fruits) {

        while(fruits.getSize() > 0) {
            coldrink.push(fruits.peek());
            fruits.pop();
        }
        while(coldrink.getSize() > 0) {
            System.out.println(coldrink.peek());
            coldrink.pop();
        }
    }

    public static void method2(StackBasic coldrink, StackBasic fruits) {

        Object[] fruitArr = fruits.getArrayOfStack();

        for(int i=0; i<fruitArr.length; i++) {
            coldrink.push(fruitArr[i]);
        }
        while(coldrink.getSize() > 0) {
            System.out.println(coldrink.peek());
            coldrink.pop();
        }
    }

    public static void mergeStack(StackBasic coldrink, StackBasic fruits) {
        for(int i=0; i< fruits.getSize(); i++) {
            coldrink.push(fruits.pop());
        }
        coldrink.display();
    }
}
