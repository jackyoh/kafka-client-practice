package idv.jack.data;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Client {
    public static void main(String args[]) throws Exception {
        String resultFilePath = "/home/user1/tool";
        int fileSize = 9;

        for(int fileIndex = 1 ; fileIndex <= fileSize ;fileIndex++) {
            GenerateData generateData = new GenerateData();
            String toolName = generateData.getToolName(1);
            String moduleName = generateData.getModuleName(1);
            String date = generateData.getDate("2016", 1, 1, "0" + fileIndex + ":00:00.000");

            String fileName = date + "_" + toolName + "_" + moduleName;
            BufferedWriter fw = new BufferedWriter(new FileWriter(resultFilePath + "/" + fileName));

            int columnNumber = 3;
            int lines = 20;

            String header = generateData.getHeader("column", columnNumber);
            fw.write(header + "\n");

            for (int k = 1; k <= lines; k++) {
                String value = generateData.getLines(fileIndex, k, columnNumber);
                fw.write(value + "\n");
            }
            fw.close();
        }
    }
}
