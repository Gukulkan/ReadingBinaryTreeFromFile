import com.gukulkan.Tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr =null;

        try {

            fis = new FileInputStream("C:\\Users\\gekh1016\\Documents\\test.txt");
            isr = new InputStreamReader(fis);

            Tree.buildTree(isr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
