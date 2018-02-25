package idv.jack.kafka.client;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class ProducerExample {

    public static void main(String args[]){
       Properties kafkaProps = new Properties();
       kafkaProps.put("bootstrap.servers", "host1:9092");
       kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

       KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);

       ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic124",
                                       "key101", "value993");
       try {
          // producer.send(record); //fire and forget
          // producer.send(record).get(); //sync

           producer.send(record, new Callback() { //async
               @Override
               public void onCompletion(RecordMetadata metadata, Exception exception) {
                   if (exception != null) {
                       //throw new RuntimeException(exception);
                       System.out.println(exception);
                   }
               }
           });
           producer.flush();
       } catch(Exception e) {
           throw new RuntimeException(e);
       }
    }
}
