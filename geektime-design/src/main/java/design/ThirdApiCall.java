package design;

/**
 * @author jiabaobao
 * @date 2023/11/14 10:47 PM
 */
public interface ThirdApiCall {

    String call(String xxx);

}


abstract class BaseThirdApiCall implements ThirdApiCall {

    abstract void before();

    abstract void after();

    @Override
    public String call(String xxx) {
        before();
        System.out.println("三方前置调用");
        after();
        return null;
    }
}

class BaiduThirdApiCall extends BaseThirdApiCall {

    @Override
    void before() {
        System.out.println("baidu 前置调用");
    }

    @Override
    void after() {
        System.out.println("baidu 后置调用");
    }

    @Override
    public String call(String xxx) {
        return super.call(xxx);
    }
}

