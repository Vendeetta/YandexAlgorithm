package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
Даны два списка чисел, которые могут содержать до 10000 чисел каждый. Выведите все числа, которые входят как в первый,
так и во второй список в порядке возрастания. Примечание. И даже эту задачу на Питоне можно решить в одну строчку.
Формат ввода

Вводятся два списка целых чисел. Все числа каждого списка находятся на отдельной строке.
Формат вывода

Выведите ответ на задачу.
 */
public class SetIntersections {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Set<Integer> a = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(TreeSet::new));

            Set<Integer> b = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            a.retainAll(b);
            a.forEach(c -> System.out.print(c + " "));
        }
    }
}
