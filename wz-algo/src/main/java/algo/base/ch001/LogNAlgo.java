package algo.base.ch001;

/**
 * 查找第一个大于2的K次方的数据
 * 1. 2. 4 8 16 32 64 128 256
 * @author qxlx
 * @date 2024/8/17 17:08
 */
public class LogNAlgo {

    public static void main(String[] args) {
        int twoNum = findTwoNum(5);
        System.out.println(twoNum);
    }

    public static int findTwoNum (int n) {
        int num = 1;
        while (num < n) {
            num *= 2;
        }
        return num;
    }

}
