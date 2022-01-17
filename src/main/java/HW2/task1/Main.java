package HW2.task1;

import HW2.task1.list.MyLinkedList;
import HW2.task1.list.MyList;

public class Main {
    public static void main(String[] args) {
        TestElement element = new TestElement();
        MyList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add(String.valueOf(element));

        System.out.println(list);
        System.out.println("Get: " + list.get(2));
        list.remove("B");
        System.out.println(list);

        var iter = list.iterator();
        while (iter.hasNext()) {
            Object next = iter.next();
            System.out.println(next);
        }

        System.out.println("=======================");

        while (iter.hasPrevious()) {
            Object prev = iter.previous();
            System.out.println(prev);
        }

        System.out.println("=======================");
        System.out.println(list.size());
    }
}
