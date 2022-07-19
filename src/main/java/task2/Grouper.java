package task2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouper {

    public static Map<String, List<Person>> groupByName(List<Person> persons){
        return persons.stream().collect(Collectors.groupingBy(Person::getName));
    }
}
