package design;

/**
 * @author jiabaobao
 * @date 2023/11/14 10:51 PM
 */
public class ThirdApiCallTest {

    public static void main(String[] args) {
        ThirdApiCall thirdApiCall = new BaiduThirdApiCall();
        thirdApiCall.call("baidu");
    }

}
