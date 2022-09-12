package homework_2.task_2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
     Task2
         [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
*/
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 7};
        int sum = 10;
        findFirstPair(array, sum);
    }

    public static void findFirstPair(int[] array, int sum) {
        Map<Integer, Integer> sumMap = getSumMap(array, sum);

        System.out.println(Arrays.toString(
                IntStream
                        .range(0, array.length)
                        .filter(Objects :: nonNull)
                        .filter(i -> sumMap.containsValue(array[i]))
                        .mapToObj(i -> new int[]{array[i], array[sumMap.get(array[i])]})
                        .findFirst()
                        .orElse(new int[0])
        ));
    }

    public static Map<Integer, Integer> getSumMap(int[] array, int sum) {
        return IntStream
                .range(0, array.length)
                .filter(Objects :: nonNull)
                .boxed()
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> sum - array[i]
                ));
    }
}



