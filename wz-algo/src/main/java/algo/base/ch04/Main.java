package algo.base.ch04;

/**
 * @author qxlx
 * @date 2024/11/17 09:32
 */
public class Main {

    public static void main(String[] args) {
        int max = getMax(5);
    }

    public static final int getMax(int n){
        if (n == 1) return 1;
        return getMax(n - 1) + 3;
    }
}
