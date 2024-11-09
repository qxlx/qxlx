package wz001;

public class CircularQueue {
    
    private int head;
    private int tail;
    private int size;
    private int [] array;

    public CircularQueue(int queueSize) {
        array = new int [queueSize+1];
        tail = 0;
        head = 0;
        size = queueSize +1;
    }

    public boolean enqueue(int item) {
        if ((tail+1)%size == head) return false;
        array[tail] = item;
        tail = (tail+1) % size;
        return true;
    }

    public int dequeue() {
        if (head == tail) return -1;
        int value = array[head];
        head = (head+1) % size;
        return value;
    }

    public boolean isEmpty() {
        return head == tail;
    }
}