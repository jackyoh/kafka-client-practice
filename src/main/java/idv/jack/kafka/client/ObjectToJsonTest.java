package idv.jack.kafka.client;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectToJsonTest {

    public static void main(String args[]){
        Gson gson = new Gson();
        for(int k =0 ; k <= 20 ; k++) {
            RunObject runObject = new RunObject();
            runObject.setStore("hdfs");

            Map<String, String> maps = new HashMap<String, String>();
            maps.put("dateTime", "2016-01-01 01:00:00.000");
            maps.put("key2", "value2");
            maps.put("key3", "value3");
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
            //System.out.println(jsonString);
        }
    }
}
