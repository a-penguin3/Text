package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(System.out::println);
        List<String> newList = new ArrayList<>();
        list.forEach(t->{
            newList.add(t + "b");
        });
        newList.forEach(System.out::println);
        list.forEach(t -> {
            t = t + "b";
        });
        list.forEach(System.out::println);
    }
}
