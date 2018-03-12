package idv.jack.data;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class PutTest {

    public static void main(String args[]) throws Exception {
        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set("hbase.zookeeper.quorum", "od2dev1");
        hbaseConfig.set("hbase.zookeeper.property.clientPort", "2181");

        HTable htable = new HTable(hbaseConfig, "table1");
        long startTime = System.currentTimeMillis();
        List<Put> puts = new ArrayList<Put>();
        for(int i = 1 ; i <= 10000 ; i++) {
            Put put = new Put(Bytes.toBytes("rowkey" + i));
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("column1"), Bytes.toBytes("value1"));
            puts.add(put);
        }
        htable.put(puts);
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        htable.close();
    }
}
