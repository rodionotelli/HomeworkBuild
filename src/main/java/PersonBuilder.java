public class PersonBuilder {
    
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0)
            throw new IllegalArgumentException("Некорректный возраст: " + age);
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (this.name == null || this.surname == null)
            throw new IllegalStateException("Необходимо указать Имя и Фамилию.");
        return new Person(this);
    }
}
