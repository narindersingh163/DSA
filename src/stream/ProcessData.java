package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessData {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 7, 5, 8, 9, 5, 3);

        list.stream()
                .sorted()
                .map(n -> n * 2)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();

        Integer reduce = list.stream()
                .sorted()
                .filter(n -> n % 2 == 1)
                .reduce(0, Integer::sum);

        list.stream()
                .sorted()
                .filter(n -> n % 2 == 1)
                .forEach(n -> System.out.print(n + " "));

        System.out.println(reduce);

        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(6,7,8,9);
        List<Integer> list3 = Arrays.asList(10,11,12,13);

        List<List<Integer>> finalList = Arrays.asList(list1, list2, list3);

        List<Integer> collect = finalList.stream()
                .flatMap(Collection::stream)
                .map(n -> n + 10)
                .collect(Collectors.toList());

        System.out.println(collect);

        Predicate<Integer> p = i -> i > 10;

        System.out.println(p.test(11));

        Function<Integer, Integer> f = i -> i * 2;

        System.out.println(f.apply(2));
    }
}
