package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }



        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            String items = iterator.toString();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }

    }
}
