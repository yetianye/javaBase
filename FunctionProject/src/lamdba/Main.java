package lamdba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }

}



class  Person {
    String name ;

    public Person(String name) {
        this.name = name;
    }


    public String toString() {
        return "123";
    }
}


class sortTest{

    public static void main(String[] args) {
       String[] aa = {"Apple", "Orange", "Banana", "Lemon"};
       Arrays.sort(aa,sortTest::compare);

        System.out.println(Arrays.toString(aa));
    }

    static int compare(String s1, String s2){
        return s1.toUpperCase().compareTo(s2.toUpperCase());
    }

}