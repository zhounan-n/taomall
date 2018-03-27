package com.zn.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

/**
 * Created by zhoun on 2018/3/27.
 **/
public class TestRedis {


    @Test
    public void testJedisCluster() {
        //logger.info("调用redisCluster开始");
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("118.126.65.244", 9001));
        nodes.add(new HostAndPort("118.126.65.244", 9002));
        nodes.add(new HostAndPort("118.126.65.244", 9003));
        nodes.add(new HostAndPort("118.126.65.244", 9004));
        nodes.add(new HostAndPort("118.126.65.244", 9005));
        nodes.add(new HostAndPort("118.126.65.244", 9006));
        //logger.info("创建一个jediscluster对象");
        JedisCluster jedisCluster = new JedisCluster(nodes);

        //logger.info("设置key1的值为1000");
        jedisCluster.set("key1", "1000");
        //logger.info("从redis中取出key1的值");
        String str = jedisCluster.get("key1");
        System.out.println(str);
        try {
            jedisCluster.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //需要密码

    }

    @Test
    public void testSpringJedisSingle(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
        JedisPool pool=(JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis=pool.getResource();
        String str=jedis.get("a");
        System.out.println(str);
        jedis.close();

    }

    @Test
    public void testSpringJedisCluster(){
        try {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
            JedisCluster jedisCluster=(JedisCluster) applicationContext.getBean("redisClient");
            String str=jedisCluster.get("a");
            System.out.println("输出："+str);
            jedisCluster.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
