package HW1.task1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setFirstName("Jack")
                .setLastName("Sparrow")
                .setMiddleName("captain")
                .setCountry("ocean")
                .setAddress("address")
                .setPhone("32233222322")
                .setAge(30)
                .setGender("male")
                .build();

        System.out.println(person);
    }
}
