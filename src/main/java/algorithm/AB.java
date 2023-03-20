package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Это ваша первая задача. В ней вам придётся прочитать два числа и сложить их.
Результат необходимо вывести на стандартный поток вывода или в файл, указанный в условии задачи.
 */
public class AB {

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            System.out.println(a + b);
        }
    }
}
