package FilterModel;

import java.io.*;
import java.util.List;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 19:51
 * Filter 模式
 */
public class Main {
    public static void main(String[] args) {

        try {
            InputStream fileInputStream = new FileInputStream("");

            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
