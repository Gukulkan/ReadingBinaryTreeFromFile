import com.gukulkan.Tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        FileInputStream fis ;
        InputStreamReader isr;

        try {

            fis = new FileInputStream("c:\\test.txt");
            isr = new InputStreamReader(fis);

            System.out.println(Tree.buildTree(isr));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
