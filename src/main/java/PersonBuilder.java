import java.util.OptionalInt;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private String address;
    private int age;


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
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() throws IllegalArgumentException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalArgumentException("поля \"name\" и \"surname\" обязательны для заполнения");
        }
        if (age < 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        } if (address != null) {
            person.setAddress(address); }
        return person;
    }
}
