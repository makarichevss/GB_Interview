package HW1.task1;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder setFirstName(String firstName){
            newPerson.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            newPerson.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName){
            newPerson.middleName = middleName;
            return this;
        }

        public Builder setCountry(String country){
            newPerson.country = country;
            return this;
        }

        public Builder setAddress(String address){
            newPerson.address = address;
            return this;
        }

        public Builder setPhone(String phone){
            newPerson.phone = phone;
            return this;
        }

        public Builder setAge(int age){
            newPerson.age = age;
            return this;
        }

        public Builder setGender(String gender){
            newPerson.gender = gender;
            return this;
        }

        public Person build(){
            return newPerson;
        }
    }
}
