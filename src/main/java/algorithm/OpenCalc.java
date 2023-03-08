package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*


В новой программе OpenCalculator появилась новая возможность – можно настроить, какие кнопки отображаются, а какие – нет.
 Если кнопка не отображается на экране, то ввести соответствующую цифру с клавиатуры
 или копированием из другой программы нельзя. Петя настроил калькулятор так,
 что он отображает только кнопки с цифрами x, y, z. Напишите программу, определяющую, сможет ли Петя ввести число N,
 а если нет, то какое минимальное количество кнопок надо дополнительно отобразить на экране для его ввода.

Формат ввода

Сначала вводятся три различных числа из диапазона от 0 до 9: x, y и z (числа разделяются пробелами).
Далее вводится целое неотрицательное число N, которое Петя хочет ввести в калькулятор. Число N не превышает 10000.

Формат вывода

Выведите, какое минимальное количество кнопок должно быть добавлено для того,
чтобы можно было ввести число N (если число может быть введено с помощью уже имеющихся кнопок, выведите 0)
 */
public class OpenCalc {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> calcBtn = Stream.of(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            Set<Integer> nmbr = Stream.of(reader.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            nmbr.removeAll(calcBtn);
            System.out.println(nmbr.size());
        }
    }
}
