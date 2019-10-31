import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class JedisTest {

    private Jedis jedis = new Jedis("localhost", 6379);

    @Test
    public void testJedis() {
        jedis.set("name", "jack");
        jedis.setex("age", 10, "20");
        Map<String, String> map = jedis.hgetAll("map");
        System.out.println(map);
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        JedisPool jedisPool = new JedisPool();
        jedis = jedisPool.getResource();
        jedis.set("gender", "male");
        jedis.close();
    }

    @Test
    public void testJedisConfig() {
        jedis = JedisUtil.getJedis();
        jedis.set("address", "北京");
        jedis.close();
    }
}
