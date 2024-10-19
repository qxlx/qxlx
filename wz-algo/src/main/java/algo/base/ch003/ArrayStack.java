package algo.base.ch003;

public class ArrayStack {


    private int [] array;
    private int cnt;
    private int size;

    public ArrayStack(int stackSize) {
        if (stackSize <= 0) return;
        array = new int[stackSize];
        cnt = 0;
        size = stackSize;
    }

    public boolean push(int value) {
        if (cnt == size) {
            return false;
        }
        array[cnt++] = value;
        return true;
    }

    public int pop() {
        if (cnt == 0) {
            return -1;
        }
        int value = array[cnt-1];
        cnt--;
        return value;
    }

    public int peek() {
        if (cnt == 0) {
            return -1;
        }
        return array[cnt-1];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

}