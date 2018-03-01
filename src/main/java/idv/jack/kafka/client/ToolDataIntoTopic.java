package idv.jack.kafka.client;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ToolDataIntoTopic {

    public static void main(String args[]) throws Exception {
       Properties kafkaProps = new Properties();
       kafkaProps.put("bootstrap.servers", "10.1.3.227:9092,10.1.3.228:9092,10.1.3.229:9092");
       kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

       KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);

       String toolFolderName = "/home/user1/tool";

       File folder = new File(toolFolderName);
       File[] listOfFiles = folder.listFiles();

       int count = 0;
       for(File listOfFile : listOfFiles){
          String fileName = listOfFile.getName();
          String fields[] = fileName.split("_");

          RunBean runBean = new RunBean();
          runBean.setStore("hdfs");

          Map<String, String> meta = new HashMap<String, String>();
          meta.put("dateTime", fields[0]);
          meta.put("toolName", fields[1]);
          meta.put("moduleName", fields[2]);
          runBean.setMeta(meta);

          Boolean isHeader = true;
          String header = null;

          String currentLine = null;

          BufferedReader br = new BufferedReader(new FileReader(listOfFile.getAbsoluteFile()));
          List<String> lines = new ArrayList<String>();

          while ((currentLine = br.readLine()) != null) {
            if (isHeader) {
              header = currentLine;
              isHeader = false;
            } else {
              lines.add(currentLine);
            }
          }
          runBean.setHeader(header);
          runBean.setLines(lines);
          br.close();

          Gson gson = new Gson();
          String result = gson.toJson(runBean);

          count ++;
          ProducerRecord<String, String> record = new ProducerRecord<String, String>("datatest4",
                   "key" + count, result);
          producer.send(record).get();
       }
       System.out.println(count);
       producer.close();
    }

}
