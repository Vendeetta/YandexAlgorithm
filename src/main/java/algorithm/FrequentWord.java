package algorithm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/*
Дан текст. Выведите слово, которое в этом тексте встречается чаще всего. Если таких слов несколько, выведите то,
которое меньше в лексикографическом порядке.
 */
public class FrequentWord {

    public static void main(String[] args) throws IOException {
            String tmp = new String(Files.readAllBytes(Path.of("/home/spaikk/Рабочий стол/Java/test.txt")));
            String[] words = tmp.split("\\s");
            Map<String, Integer> map = new HashMap<>();
            int count = 0;
            String ans = words[0];
            for (int i = 0; i < words.length; i++) {
                String s = words[i];
                map.merge(s, 1, (a, b) -> a + 1);
                int curCount = map.get(s);
                if (count < curCount || (count == curCount && s.compareTo(ans) < 0)) {
                    count = curCount;
                    ans = s;
                }
            }
            System.out.println(ans);
        }
    }

