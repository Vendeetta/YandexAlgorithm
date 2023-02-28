package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Дан список чисел. Определите, сколько в этом списке элементов, которые больше двух своих соседей
 и выведите количество таких элементов.

Формат ввода
Вводится список чисел. Все числа списка находятся на одной строке.

Формат вывода
Выведите ответ на задачу.
 */
public class BiggerThenNeighbour {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer[] list = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            int count = 0;
            for (int i = 1; i < list.length - 1; i++) {
                if (list[i] > list[i - 1] && list[i] > list[i + 1])
                    count++;
            }
            System.out.println(count);
        }
    }
}
