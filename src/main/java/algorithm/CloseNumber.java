package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/*
Напишите программу, которая находит в массиве элемент, самый близкий по величине к  данному числу.

Формат ввода
В первой строке задается одно натуральное число N, не превосходящее 1000 – размер массива.
 Во второй строке содержатся N чисел – элементы массива (целые числа, не превосходящие по модулю 1000).
  В третьей строке вводится одно целое числNeо x, не превосходящее по модулю 1000.

Формат вывода
Вывести значение элемента массива, ближайшее к x. Если таких чисел несколько, выведите любое из них.
 */
public class CloseNumber {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] tmp = reader.readLine().split(" ");
            int x = Integer.parseInt(reader.readLine());
            int answer = 0;
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < tmp.length; i++) {
                int numb = Integer.parseInt(tmp[i]);
                int abs = Math.abs(x - numb);
                if (abs == 0) {
                    answer = numb;
                    break;
                }
                if (abs < diff) {
                    diff = abs;
                    answer = numb;
                }
            }
            System.out.println(answer);
        }
    }
}
