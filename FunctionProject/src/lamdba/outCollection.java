package lamdba;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 输出集合
 */
public class outCollection {
//    输出为List
    public static void main(String[] args) {
       /* Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> collect = stream.filter(n -> n != null && !n.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);*/


        /*Stream<String> list = Stream.of("Apple", "Banana", "Orange");
        String[] array = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array));*/


        /*Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> collect = stream.collect(Collectors.toMap(
                s -> s.split(":")[0],
                s -> s.split(":")[1]));
        System.out.println(collect);*/

        Map<String, List<String>> collect = Stream.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots")
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));

        System.out.println(collect);
    }
}

//Stream<Student>，利用分组输出，可以非常简单地按年级或班级把Student归类
class outCollectionHomeWork{
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student(1, 1, "A", 80),
                new Student(1, 2, "B", 90),
                new Student(1, 3, "C", 100),
                new Student(2, 1, "D", 90),
                new Student(2, 2, "E", 100),
                new Student(2, 3, "F", 80),
                new Student(3, 1, "G", 100),
                new Student(3, 2, "H", 80),
                new Student(3, 3, "I", 90)
        );

        Map<Integer, List<Student>> collect = studentStream.collect(Collectors.groupingBy(
                s -> s.getClassId(),
                Collectors.toList()
        ));

        collect.entrySet().stream().forEach((e)-> {
            System.out.println("key:" + e.getKey());
            List<Student> value = e.getValue();
            value.forEach(s-> System.out.println("name:" + s.getName() + "," +
                    "classId：" + s.getClassId() + "," +
                    "gradeId:" + s.getGradeId() + "," +
                    "score:" +s.getScore()) );
        });
    }

}

class Student {
    int gradeId; // 年级
    int classId; // 班级
    String name; // 名字
    int score; // 分数

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int gradeId, int classId, String name, int score) {
        this.gradeId = gradeId;
        this.classId = classId;
        this.name = name;
        this.score = score;
    }
}
