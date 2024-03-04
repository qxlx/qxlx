package ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;

/**
 * @author qxlx
 * @date 2024/2/25 17:39
 */
public class EhcacheTest {

    @Test
    public void test(){
        //1. 初始化好CacheManager
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                // 一个CacheManager可以管理多个Cache
                .withCache(
                        "singleDog",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                String.class,
                                Object.class,
                                // heap相当于设置数据在堆内存中存储的 个数 或者 大小
                                ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10).build()).build()
                ).build(true);
//        cacheManager.init();

        //2. 基于CacheManager回去到Cache对象
        Cache<String, Object> cache = cacheManager.getCache("singleDog", String.class, Object.class);

        //3. 存  set/put/add/
        cache.put("ehcache","57个单身狗！！");

        //4. 取
        System.out.println(cache.get("ehcache"));
    }

}
