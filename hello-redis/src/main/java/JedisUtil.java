import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {

    private static JedisPool jedisPool;

    static {
        try {
            InputStream is = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
            Properties prop = new Properties();
            prop.load(is);
            int maxTotal = Integer.parseInt(prop.getProperty("maxTotal"));
            String host = prop.getProperty("host");
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            jedisPool = new JedisPool(config, host);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
