/**
 * Created by Administrator on 2017/12/15 0015.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class testCase {
    private static File createFile(String path, String fileName) {
        File file = new File(path, fileName);

        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }

    public static void main(String[] args) throws IOException {             //需要对IO异常进行处理

        File file1= createFile("/data/local/tmp/","2.txt");

        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream p = new PrintStream(fs);
        p.println("qwsadadada");
    }
}
