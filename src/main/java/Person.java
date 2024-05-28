
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;

    protected Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age = getAge().getAsInt() + 1;
    }

    @Override
    public String toString() {
        return name + " " + surname + " [возраст - " + getAge().getAsInt()
                + ", место жительства - " + address + "]";
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address)
                .setAge(0);
    }
}