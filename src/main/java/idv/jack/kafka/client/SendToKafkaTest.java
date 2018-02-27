package idv.jack.kafka.client;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.*;

public class SendToKafkaTest {

    public static void main(String args[]) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "10.1.3.227:9092,10.1.3.228:9092,10.1.3.229:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);


        try {
            // producer.send(record); //fire and forget
            // producer.send(record).get(); //sync
            Gson gson = new Gson();

            for(int k =0 ; k <= 200000 ; k++) {
                RunObject runObject = new RunObject();
                runObject.setStore("hdfs");

                Map<String, String> maps = new HashMap<String, String>();
                maps.put("dateTime", "2016-01-01 01:00:00.000");
                maps.put("toolName", "tool001");
                maps.put("moduleName", "module001");
                runObject.setMeta(maps);

                runObject.setHeader("column1,column2,column3,column4,column5");

                List<String> lines = new ArrayList<String>();

                for (int i = 1; i <= 100; i++) {
                    StringBuffer line = new StringBuffer("value" + i + "-1");
                    for (int j = 2; j <= 10; j++) {
                        line.append(",value" + i + "-" + j);
                    }
                    lines.add(line.toString());
                }

                runObject.setLines(lines);

                String jsonString = gson.toJson(runObject);
                ProducerRecord<String, String> record = new ProducerRecord<String, String>("datatest3",
                        "key" + k, jsonString);

                producer.send(record, new Callback() { //async
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null) {
                            //throw new RuntimeException(exception);
                            System.out.println(exception);
                        }
                    }
                });
            }
            producer.flush();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }


    }

}
