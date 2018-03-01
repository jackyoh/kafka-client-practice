package idv.jack.data;

public class GenerateData {

    public String getToolName(int number){
        return "tool" + String.format("%03d", number);
    }

    public String getModuleName(int number){
        return "module" + String.format("%03d", number);
    }

    public String getDate(String year, int month, int day, String time){
        return year + "-" +
               String.format("%02d", month) + "-" +
               String.format("%02d", day) + " " +
               time;
    }

    public String getHeader(String columnPrefix, int number){
        StringBuffer columnNames = new StringBuffer();
        for(int i = 1; i <= number; i++) {
            columnNames.append(columnPrefix + i + ",");
        }
        return columnNames.substring(0, columnNames.length() - 1);
    }

    public String getLines(int runNumber, int line, int number){
        StringBuffer values = new StringBuffer();
        for(int i = 1; i <= number; i++) {
            values.append("run" + runNumber + "-value" + line + "-" + i + ",");
        }
        return values.substring(0, values.length() - 1);
    }

}
