package algo.base.ch001;

/**
 * @author qxlx
 * @date 2024/8/17 17:19
 */
public class DynamicArrayDemo {

    private int [] array = new int [10];
    private int size;

    public void add(int data) {
        if (size == array.length) {
            int [] tmp = new int[array.length * 2];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }
        array[size++] = data;
    }

    public static void main(String[] args) {
        DynamicArrayDemo demo = new DynamicArrayDemo();
        for (int i = 0; i < 10; i++) {
            demo.add(i);
        }

        for (int i = 0; i < 10; i++) {
            demo.add(i);
        }
        System.out.println(demo.array);
    }

}
