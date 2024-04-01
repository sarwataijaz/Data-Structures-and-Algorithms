public class ArrayQueue {
    private Object[] arr;
    private int size=0;

    ArrayQueue(int capacity) {
        arr= new Object[capacity];
    }

    public Object first() {
        if(size==0){
            throw new IllegalStateException("Queue is empty.");
        }
        return arr[0];
    }
    public Object dequeue() {
        if(size==0){
            throw new IllegalStateException("Queue is empty.");
        }
        Object temp = arr[0];
        for(int i=0; i<size; i++) {
            arr[i] = arr[i+1];
        }
        return temp;
    }

    public void enqueue(Object obj) {
        if(size == arr.length) {
            resize();
        }
        arr[++size] = obj;
    }

    public int getSize(){
        return size;
    }

    public void resize() {
        Object[] temp = arr;
        arr = new Object[2* temp.length];
        System.arraycopy(temp,0,arr,0,size);
    }
}

class Passenger {
    ArrayQueue passengerName = new ArrayQueue(5);
    ArrayQueue passengerLuggaeNo = new ArrayQueue(5);

    void getPassengerInfo() {
        for (int i = 0; i < passengerName.getSize(); i++) {
            System.out.println("Passenger Name: " + passengerName.dequeue());
            System.out.println("Passenger Luggage number: " + passengerLuggaeNo.dequeue());
        }
    }
}
