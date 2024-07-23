package ch11;

/**
 * @author qxlx
 * @date 2024/7/22 08:11
 */
public class AuthencationFilter implements Filter{

    @Override
    public void doFilter() {
        System.out.println("鉴权验证");
    }
}
