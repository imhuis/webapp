package com.imhui.core.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.SocketOptions;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisConfiguration {
    /**
     * RedisConnectionFactory
     * + {@link JedisConnectionFactory}
     * + {@link LettuceConnectionFactory}
     */


    public JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }

    /**
     * 使用spring提供的工厂类或者jedisPool
     * @return
     */
    public JedisPool jedisPool(){
        return new JedisPool(jedisPoolConfig());
    }



    public GenericObjectPoolConfig genericObjectPoolConfig(){
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMinIdle(5);
        genericObjectPoolConfig.setMaxIdle(10);
        genericObjectPoolConfig.setMaxTotal(20);
        return genericObjectPoolConfig;
    }

    /**
     * 单机配置
     */
    public JedisConnectionFactory standaloneJedisConnectionFactory(RedisStandaloneConfiguration configuration){
        return new JedisConnectionFactory(configuration);
    }

    /**
     * 哨兵配置
     */
    public JedisConnectionFactory sentinelJedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration()
                .master("master")
                .sentinel("",26378)
                .sentinel("",26379);
        return new JedisConnectionFactory(redisSentinelConfiguration, jedisPoolConfig);
    }

    /**
     * 集群配置
     * redis cluster
     * 1.数据自动分片（16384个Hash Slot）
     * 注意：jedis只能从master进行数据读写
     */
    @Bean(destroyMethod = "")
    public LettuceConnectionFactory lettuceConnectionFactory(){
        RedisClusterConfiguration redisClusterConnection = new RedisClusterConfiguration();
        redisClusterConnection.addClusterNode(new RedisNode("redis1",26379));
        redisClusterConnection.addClusterNode(new RedisNode("redis2",26379));
        redisClusterConnection.addClusterNode(new RedisNode("redis3",26379));
        redisClusterConnection.setMaxRedirects(3);

        ClusterTopologyRefreshOptions clusterTopologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
                .enablePeriodicRefresh(Duration.ofSeconds(60))
                .enableAdaptiveRefreshTrigger(ClusterTopologyRefreshOptions.RefreshTrigger.ASK_REDIRECT, ClusterTopologyRefreshOptions.RefreshTrigger.UNKNOWN_NODE)
                .build();

        ClusterClientOptions clusterClientOptions = ClusterClientOptions.builder()
                .topologyRefreshOptions(clusterTopologyRefreshOptions)// 拓扑刷新
                .disconnectedBehavior(ClientOptions.DisconnectedBehavior.REJECT_COMMANDS)
                .autoReconnect(true)
                .socketOptions(SocketOptions.builder().keepAlive(true).build())
                .validateClusterNodeMembership(false)// 取消校验集群节点的成员关系
                .build();

        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder()
//                .clientOptions(clusterClientOptions)
//                .readFrom(ReadFrom.ANY)
                .commandTimeout(Duration.ofMillis(1000))
                .poolConfig(genericObjectPoolConfig())
                .build();

        return new LettuceConnectionFactory(redisClusterConnection, clientConfiguration);
    }

}
