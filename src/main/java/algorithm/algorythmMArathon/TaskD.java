package algorithm.algorythmMArathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Дано кубическое уравнение

    ax3 + bx2 + cx + d = 0 (a ≠ 0).

    Известно, что оно имеет ровно один вещественный корень. Найдите его.
    Входные данные

    Four integers: a, b, c, d (-1000 ≤ a, b, c, d ≤ 1000).
    Выходные данные

    Выведите единственный корень уравнения с точностью не менее 66 знаков после десятичной точки.
 */
public class TaskD {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = reader.readLine().split(" ");
            double a = Double.parseDouble(tmp[0]);
            double b = Double.parseDouble(tmp[1]);
            double c = Double.parseDouble(tmp[2]);
            double d = Double.parseDouble(tmp[3]);
            double l = -10000;
            double r = 10000;
            int i = 0;
            while (i < 1000000) {
                double x = (l + r)/ 2;
                double res = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
                if (a > 0) {
                    if (res > 0){
                        r = x;
                    } else {
                        l = x;
                    }
                } else {
                    if (res > 0) {
                        l = x;
                    } else {
                        r = x;
                    }
                }
                i++;
            }
            System.out.print(l);
        }
    }
}
