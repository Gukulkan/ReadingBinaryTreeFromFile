import com.gukulkan.StreamTreeFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

    public static final String DEFAULT_FILE_PATH = "c:\\test.txt";

    public static void main(String[] args) {
        FileInputStream fis;
        InputStreamReader isr;

        String filePath = DEFAULT_FILE_PATH;

        if (args != null && args.length > 0) {
            filePath = args[0];
        }

        try {

            fis = new FileInputStream(filePath);
            isr = new InputStreamReader(fis);

            System.out.println(StreamTreeFactory.buildTree(isr));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
