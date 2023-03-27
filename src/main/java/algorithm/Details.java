package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*


Имеется N кг металлического сплава. Из него изготавливают заготовки массой K кг каждая.
После этого из каждой заготовки вытачиваются детали массой M кг каждая
(из каждой заготовки вытачивают максимально возможное количество деталей).
Если от заготовок после этого что-то остается, то этот материал возвращают к началу производственного цикла
и сплавляют с тем, что осталось при изготовлении заготовок. Если того сплава,
который получился, достаточно для изготовления хотя бы одной заготовки, то из него снова изготавливают заготовки,
из них – детали и т.д. Напишите программу, которая вычислит,
какое количество деталей может быть получено по этой технологии из имеющихся исходно N кг сплава.
Формат ввода

Вводятся N, K, M. Все числа натуральные и не превосходят 200.
Формат вывода

Выведите одно число — количество деталей, которое может получиться по такой технологии.
 */
public class Details {

    public static void main(String[] args) throws IOException {
        int[] tmp = readData();
        int totalDetails = 0;
        while (tmp[1] <= tmp[0]) {
            if (tmp[2] > tmp[1])
                break;
            tmp[0] -= tmp[1];
            totalDetails += tmp[1] / tmp[2];
            tmp[0] += tmp[1] % tmp[2];
        }
        System.out.println(totalDetails);

    }

    private static int[] readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = reader.readLine().split(" ");
            int[] res = new int[3];
            res[0] = Integer.parseInt(tmp[0]);
            res[1] = Integer.parseInt(tmp[1]);
            res[2] = Integer.parseInt(tmp[2]);
            return res;
        }
    }
}
