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
            double l = -2;
            double r = 2;
            double ans = 0;
            if (a > 0)
                ans = -d;
            while (r - l > 1e-6) {
                double x = l + (r - l) / 2;
                if (a * Math.pow(x, 3) + b * Math.pow(x, 2) + (c * x ) > ans) {
                    r = x;
                }
                else {
                    l = x;
                }
            }
            System.out.println((l+r) / 2);
        }
    }
}
