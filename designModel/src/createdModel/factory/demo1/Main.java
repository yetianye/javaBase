package createdModel.factory.demo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 13:23
 * 静态工厂模式
 * 简化的使用静态方法创建产品的方式称为静态工厂方法（Static Factory Method）
 */
public class Main {
    public static void main(String[] args) {
        //静态工厂模式
        Integer.valueOf(123);

        HashMap map = new HashMap();


    }
}

class LocalDateFactory {
    public static LocalDate formatInt(int yyyyMMdd){
        return LocalDate.of(yyyyMMdd/10000,yyyyMMdd/100%100,yyyyMMdd%100);
    }
}
