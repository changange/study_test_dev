package com.itany;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Author：耿常安
 * Date：2021-03-18-18:49
 * Description：<描述>
 */
public class HelloZookeeper {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //获取zookeeper连接，也就是穿件客户端
        String connectString="212.64.42.233:2181";    //zookeeper服务器端额地址
        int sessionTime = 3000;    //超时时间
        //监视器
        Watcher myWatcher = new MyWatcher();
        ZooKeeper zkClient = new ZooKeeper(connectString,sessionTime,myWatcher);

        Thread.sleep(2000);     //觉得可有可无
        //查看连接的状态   CONNECTED已经连接上
        System.out.println(zkClient.getState());

        /**
         * 操作zookeeper
         */
        // List<String> children = zkClient.getChildren("/", true);//第二个参数就是是否监视节点
        // System.out.println(children);

        //创建节点 OPEN_ACL_UNSAFE：ACL权限列表为完全开放     PERSISTENT：节点类型为持久化
        // zkClient.create("/world","世界".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //获取节点的数据   true：是否监视   null：节点状态
        // byte[] data = zkClient.getData("/gca", true, null);
        // System.out.println(new String(data));

        //获取节点的状态
        // Stat stat = new Stat();
        // byte[] data1 = zkClient.getData("/world", true, stat);       //true:表示上边的那个watcher
        // byte[] data = zkClient.getData("/world", new DataWatch(), stat);     //new DataWatch(),
        // System.out.println(new String(data));
        // System.out.println(stat);       //状态（就是这个节点信息）
        // System.out.println(stat.getCtime());    //创建时间
        // System.out.println(stat.getVersion());    //版本
        // System.out.println(stat.getDataLength());    //数据的长度

        //修改节点数据
        // zkClient.setData("/hello","hhh".getBytes(),1);  //第三个参数表示当前数据版本（dataVersino）,用ls2查看，这个版本号修改一次变一次！   也可以设置为-1就是不检测版本
        // zkClient.setData("/world","hhh".getBytes(),stat.getVersion());  //一般先获取数据的状态的版本，然后再去修改

        //删除节点
        // zkClient.delete("/world",-1);

        //判断节点是否存在
        // System.out.println(zkClient.exists("/hello",false));    //false：是否监听    没有就返回null

        //休眠    方便查看监听值的变化
        // Thread.sleep(100000);


        //关闭
        // zkClient.close();
    }
}
