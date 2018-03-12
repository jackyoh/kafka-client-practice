package idv.jack.data;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class CreateHDFSFolder {

    public static void main(String args[]) throws Exception {
        Configuration config = new Configuration();
        config.set("fs.default.name", "hdfs://hdfs:9000");

        String rootDirs = "/data1";
        FileSystem fs = FileSystem.get(config);

        for(int i = 1 ; i <= 2 ; i++) {// tool
            for(int j = 1 ; j <= 3 ; j++) {
               for(int k = 1 ; k <=2 ; k++) {
                   for(int p = 0 ; p < 3 ; p++) {
                       String toolPath = "";
                       toolPath = rootDirs + "/tool00" + i + "/module00" + j + "/20160" + k + "/partition=" + p;
                       fs.mkdirs(new Path(toolPath));

                       String filePathAndName1 = toolPath + "/" + "20160" + k + "0101-08e6e9e0d4decd31c8cf687180a2eae7";
                       createFile(filePathAndName1, "tool00" + i, "module00" + j, "partition=" + p, "20160" + k);

                       String filePathAndName2 = toolPath + "/" + "20160" + k + "0101-9c64204155086522a1f49c0cb3ff6932";
                       createFile(filePathAndName2, "tool00" + i, "module00" + j, "partition=" + p, "20160" + k);
                   }
               }

            }
        }

    }

    public static void createFile(String filePathAndName, String tool, String module, String partition, String yearmonth) {
       try {
           Configuration config = new Configuration();
           config.set("fs.default.name", "hdfs://hdfs:9000");

           FileSystem fs = FileSystem.get(config);
           OutputStream outputStream = fs.create(new Path(filePathAndName), true);
           String value = tool + "," + module + "," + partition + "," + yearmonth + "\n";
           outputStream.write(value.getBytes());
           outputStream.close();

       } catch(Exception e) {
           throw new RuntimeException(e);
       }

    }
}
