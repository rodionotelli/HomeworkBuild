import java.util.OptionalInt;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private String address;
    private OptionalInt age = OptionalInt.empty();


    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Введите имя");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Введите фамилию");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        } else {
            this.age = OptionalInt.of(age);
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    protected Person getPerson() {
    if (!age.isPresent()) return new Person(name, surname);
    else return new Person(name, surname, age.getAsInt());
    }

    @Override
    public Person build() {
        if (name == null && surname == null) throw new IllegalStateException("Заполнены не все данные");
        Person person = getPerson();
        person.setAddress(address);
        return person;
    }
}
