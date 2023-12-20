// stack implementation using Arrays.
interface Stack {
    public Object peek();
    public void push(Object obj);
    public Object pop();
    public int getSize();
}
public class StackBasic implements Stack {

    Object[] arr;
    public int size = 0;
    StackBasic(int capacity) {
        arr = new Object[capacity];
    }
    @Override
    public Object peek() {
       if(size == 0) { // thru size variable we can track how many elements have been stored in a stack
           throw new IllegalStateException("Stack is empty.");
       }

       return arr[size-1];
    }

    @Override
    public void push(Object obj) {

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
    @Override
    public Object pop() {
        if(size == 0) { // thru size variable we can track how many elements have been stored in a stack
            throw new IllegalStateException("Stack is empty.");
        }
        Object temp = arr[--size];
        arr[size] = null;
        return temp; // return the deleted element.
    }

    @Override
    public int getSize() {
        return size;
    }

    public Object[] getArrayOfStack(){
        return arr;
    }

    public static void main(String[] args) {
        StackBasic coldrink = new StackBasic(3);
        coldrink.push("Pepsi");
        coldrink.push("Marinda");
        coldrink.push("Dew");
        coldrink.push("colacola");
        coldrink.push("fanta");

//        while(coldrink.getSize() > 0) {
//            System.out.println(coldrink.peek());
//            coldrink.pop();
//        }

        StackBasic fruits = new StackBasic(3);
        coldrink.push("Strawberry");
        coldrink.push("Cheeku");
        coldrink.push("Banana");
        coldrink.push("Apple");
        coldrink.push("Orange");

     method1(coldrink,fruits);
     method2(coldrink,fruits);

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
}
