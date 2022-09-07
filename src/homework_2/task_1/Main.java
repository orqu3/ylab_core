package homework_2.task_1;
/*
     Task1
         Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

         Что должно получиться Key: Amelia
             Value:4
             Key: Emily
             Value:1
             Key: Harry
             Value:3
             Key: Jack
             Value:1
      */

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    record Person(int id, String name) {

        @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person person)) return false;
                return id() == person.id() && name().equals(person.name());
            }

            @Override
            public int hashCode() {
                return Objects.hash(id(), name());
            }
        }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };


    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Map<String, Long> result = getSortedMapWithoutDuplicateFromPersonArray(RAW_DATA);

        printMap(result);
    }

    public static Map<String, Long> getSortedMapWithoutDuplicateFromPersonArray(Person[] array) {
        return Arrays
                .stream(array)
                .distinct()
                .sorted(Comparator
                        .comparing(Person::name)
                        .thenComparing(Person::id))
                .collect(Collectors
                        .groupingBy(Person::name, LinkedHashMap::new, Collectors.counting()));
    }

    public static void printMap(Map<?, ?> map) {
        map
                .forEach((name, count) ->
                        System.out.println("Key: " + name + "\n" + "Value:" + count));
    }
}

