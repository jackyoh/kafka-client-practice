package idv.jack.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class Client {
    public static void main(String args[]) throws Exception {
        Random random = new Random();

        String resultFilePath = "/home/user1/tool";

        int moduleSize = 3;
        int hourSize = 10;
        int daySize = 20;

        for(int moduleIndex = 1; moduleIndex <= moduleSize; moduleIndex++) {
          GenerateData generateData = new GenerateData();
          String toolName = generateData.getToolName(1);
          String moduleName = generateData.getModuleName(moduleIndex);

          for(int hourIndex = 0; hourIndex < hourSize; hourIndex++) {
            for(int dayIndex = 1; dayIndex < daySize; dayIndex++) {
            String date = generateData.getDate("2016", 1, dayIndex, String.format("%02d", hourIndex) + ":00:00.000");

            String fileName = date + "_" + toolName + "_" + moduleName;
            BufferedWriter fw = new BufferedWriter(new FileWriter(resultFilePath + "/" + fileName));

            int columnSize = random.nextInt(3) + 1;
            int lines = random.nextInt(500) + 100;

            String header = generateData.getHeader("column", columnSize);
            fw.write(header + "\n");

            for (int k = 1; k <= lines; k++) {
              String value = generateData.getLines(dayIndex, k, columnSize);
              fw.write(value + "\n");
            }
            fw.close();
          }
        }
      }

    }
}
