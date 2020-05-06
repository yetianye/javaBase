import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        readFile();
        readFile();

    }
    public static void readFile() throws IOException {
        try (InputStream input = new FileInputStream("E:\\ftp\\readme.txt")) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        } // 编译器在此自动为我们写入finally并调用close()
    }
    public static void readFile2() throws IOException {
        try (InputStream input = new FileInputStream("E:\\ftp\\readme.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }
    }

}
