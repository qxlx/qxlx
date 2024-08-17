package algo.base.ch001;

import java.util.Arrays;

/**
 * @author qxlx
 * @date 2024/8/17 17:44
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        reverse(ints);
        Arrays.stream(ints).forEach(value -> System.out.println(value));
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }
    }

}
