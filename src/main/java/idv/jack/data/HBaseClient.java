package idv.jack.data;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import java.io.IOException;

public class HBaseClient {

    public static void main(String args[]) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "hdfs");
        config.set("hbase.zookeeper.property.clientPort", "2181");

        HTable htable = new HTable(config, "table1");
        ResultScanner resultScanner = htable.getScanner(new Scan());
        for(Result result: resultScanner){
            System.out.println(result);
        }

        htable.close();
    }

}
