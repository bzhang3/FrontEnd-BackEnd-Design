package com.bing.zookeeper;

/**
 * Created by bingzhang on 8/23/17.
 *
 *
 */

import com.linkedin.d2.balancer.util.LoadBalancerClientCli;

import java.io.File;

public class RunZoo {



    public static void main(String[] args) throws Exception{

        final int discoveryResult = LoadBalancerClientCli.runDiscovery("localhost:2181", "/d2", new File("/Users/bingzhang/SystemDesign/zookeeper/zookeeperRun/src/main/java/com/bing/zookeeper/data.json"));

    }
}
