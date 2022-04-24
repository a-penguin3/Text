import java.util.Arrays;

import java.util.LinkedList;

import java.util.Scanner;

import java.util.TreeSet;

public class Test {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 0, 5, 6, 7, 8, 0, 0, 0, 1, 2, 3};

        LinkedList<Integer> lin = new LinkedList<>();

        lin.addAll(Arrays.asList(arr));

        while (true) {

            sop(Arrays.toString(arr));

            sop("输入想查找的值:");

            int value = sc.nextInt();

            lookUp(lin, value);

        }

    }

    public static void lookUp(LinkedList<?> list, int key) {

        LinkedList<?> tem = (LinkedList<?>) list.clone();

        TreeSet<Integer> ts = new TreeSet<>();

        int count = 0;

        while (true) {

            int x = tem.indexOf(key);

            int y = tem.lastIndexOf(key);

            if (x < 0 || y < 0) {

                break;

            }

            if (x != y) {

                count += 2;

                tem.removeFirstOccurrence(key);

                tem.removeLastOccurrence(key);

                ts.add(x);

                ts.add(y);

            } else {

                count++;

                ts.add(y);

                break;

            }

        }

        if (count < 1) {

            sop("目标不存在\r\n");

            return;

        }

        sop("目标索引位置是:" + ts + "\t该值共:" + ts.size() + " 个\r\n");

    }

    private static void sop(String str) {

        System.out.println(str);

    }

}