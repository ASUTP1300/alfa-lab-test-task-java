package task2;

public class Person implements NamedObject{

    private String name;

    private String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nГражданин:\n" +
                "\tИмя: " + name + '\n' +
                "\tФамилия: " + lastName;
    }
}
