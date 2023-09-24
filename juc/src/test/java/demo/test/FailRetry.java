package demo.test;

/**
 * @author jiabaobao
 * @date 2023/7/20 10:10 PM
 */
public class FailRetry {

    public static void main(String[] args) {
        Float number = new Float(12443443);
        byte[] bytes = float2byte(number);
        Float number2 = getFloat(bytes);
        System.out.println(number2);
    }

    public static Float getFloat(byte bytes[]) {
        int result = (bytes[0] & 0XFF) |
                ((bytes[1] & 0XFF) << 8) |
                ((bytes[2] & 0xFF) << 16) |
                ((bytes[3] & 0XFF) << 24);
        float v = Float.intBitsToFloat(result);
        return v;
    }


    public static byte[] float2byte(float f) {

        // 把float转换为byte[]
        int fbit = Float.floatToIntBits(f);

        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (fbit >> (24 - i * 8));
        }

        // 翻转数组
        int len = b.length;
        // 建立一个与源数组元素类型相同的数组
        byte[] dest = new byte[len];
        // 为了防止修改源数组，将源数组拷贝一份副本
        System.arraycopy(b, 0, dest, 0, len);
        byte temp;
        // 将顺位第i个与倒数第i个交换
        for (int i = 0; i < len / 2; ++i) {
            temp = dest[i];
            dest[i] = dest[len - i - 1];
            dest[len - i - 1] = temp;
        }

        return dest;

    }


//
//    private static void FileAuth() {
//    }
//
//    private static void WeChatRun() {
//    }

}
