package idv.jack.data;

public class Client {
    public static void main(String args[]){
        GenerateData generateData = new GenerateData();
        String toolName = generateData.getToolName(1);
        String moduleName = generateData.getModuleName(1);
        String date = generateData.getDate("2016", 1, 1, "01:00:00.000");
        String header = generateData.getHeader("column", 10);
        String value = generateData.getLines(10);

        System.out.println(toolName);
        System.out.println(moduleName);
        System.out.println(date);
        System.out.println(header);
        System.out.println(value);
        
    }
}
