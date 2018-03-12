package idv.jack.data;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String args[]){
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("key1", "value1");
        maps.put("key2", "value2");

        System.out.println(maps.size());
        maps.clear();
        System.out.println(maps.size());
    }

}
