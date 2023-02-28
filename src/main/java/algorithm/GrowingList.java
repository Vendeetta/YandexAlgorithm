package algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Дан список. Определите, является ли он монотонно возрастающим(то есть верно ли,
что каждый элемент этого списка больше предыдущего).
Выведите YES, если массив монотонно возрастает и NO в противном случае.
 */
public class GrowingList {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isGrowing = true;
            Integer[] list = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] >= list[i + 1]) {
                    isGrowing = false;
                    break;
                }
            }
            if (isGrowing)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
