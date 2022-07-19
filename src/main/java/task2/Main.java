package task2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Руслан", "Манасипов");
        Person person2 = new Person("Руслан", "Иванов");
        Person person3 = new Person("Мария", "Кох");

        List<Person> persons = List.of(person1, person2, person3);

        Map<String, List<Person>> groupList = Grouper.groupByName(persons);
        printMap(groupList);
    }

    static void printMap(Map<String, List<Person>> groupList){
        groupList.forEach((k, v) -> {
            System.out.println("\nИмя: " + k);
            v.forEach(System.out :: println);
            System.out.println("\n");
        });
    }

}
