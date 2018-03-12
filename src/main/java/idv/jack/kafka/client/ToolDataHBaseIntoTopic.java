package idv.jack.kafka.client;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ToolDataHBaseIntoTopic {

    public static void main(String args[]) throws Exception {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "10.1.3.227:9092,10.1.3.228:9092,10.1.3.229:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);

        int count = 0;

        for(int i = 1; i <= 9; i++) {
            HBaseRunBean hbaseRunBean = new HBaseRunBean();
            hbaseRunBean.setStore("hbase");

            Map<String, String> meta = new HashMap<String, String>();
            meta.put("dateTime", "2016-01-0" + i + " 01:00:00.000");
            meta.put("toolName", "tool001");
            meta.put("moduleName", "module001");
            hbaseRunBean.setMeta(meta);

            hbaseRunBean.setRawtrace_header("column1,column2,column3");
            hbaseRunBean.setRowkey("rowkey" + i);

            Map<String, String> value = new HashMap<String, String>();
            value.put("key1", "value1");
            value.put("key2", "value2");
            value.put("key3", "value3");
            hbaseRunBean.setValue(value);

            Gson gson = new Gson();
            String result = gson.toJson(hbaseRunBean);

            count++;

            ProducerRecord<String, String> record = new ProducerRecord<String, String>("datatest8",
                    "key" + count, result);
            producer.send(record).get();
            System.out.println(result);

        }

    }


}
