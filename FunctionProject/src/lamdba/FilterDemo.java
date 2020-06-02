package lamdba;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FilterDemo{
    public static void main(String[] args) {

        IntStream.of(1,3,2,5,4,3).filter((n)-> n % 2 != 0 ).forEach(System.out::print);
        System.out.println("--------------");

        //Stream.generate(new numSupliter()).limit(10).forEach(System.out::print);

        List<Persons> persons = Arrays.asList(new Persons("小明", 88), new Persons("小黑", 62), new Persons("小白", 45),
                new Persons("小黄", 78), new Persons("小红", 99), new Persons("小林", 58));
        // 请使用filter过滤出及格的同学，然后打印名字:

        persons.stream()
                .filter((person)->person.getScore() > 60 )
                .forEach((person)-> System.out.println(person.getName() + ":" + person.getScore()));

    }
}


class Persons {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    Persons(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

//日期自增
class LocalDateSupplier implements  Supplier{

    @Override
    public Object get() {
        return null;
    }
}


//自增序列
class numSupliter implements Supplier{

    int n = 0;

    @Override
    public Object get() {
        return n ++ ;
    }
}