import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.lanag.String;
import java.util.List;

public class Data {
    public static void main(String[] args) {
        try {
            List<String> lines= Files.readAllLines(Paths.get("E:\\data\\CollageData.csv"));
            for(String line:lines) {
                line = line.replace("\"", "");
                String []result=line.split(",");
                for (String str : result)
                    System.out.print(str);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
