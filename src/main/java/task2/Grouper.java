package task2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouper {

    public  static <T extends NamedObject> Map<String, List<T>> groupByName(List<T> namedObjects){
        return namedObjects.stream().collect(Collectors.groupingBy(T ::getName));
    }
}
