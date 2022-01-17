package HW2.task2;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
        }

        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
    }
}
