package ch11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qxlx
 * @date 2024/7/22 08:12
 */
public class FilterApplicationTest {

    private static List<Filter> filters;

    static {
        if (filters == null) {
            filters = new ArrayList<>();
            filters.add(new AuthencationFilter());
            filters.add(new RateLimitFilter());
        }
    }

    public static void main(String[] args) {
        for (Filter filter : filters) {
            filter.doFilter();
        }
    }

}
