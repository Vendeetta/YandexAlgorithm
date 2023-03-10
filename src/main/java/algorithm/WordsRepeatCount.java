package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Во входном файле (вы можете читать данные из файла input.txt) записан текст.
Словом считается последовательность непробельных символов идущих подряд,
слова разделены одним или большим числом пробелов или символами конца строки.
Для каждого слова из этого текста подсчитайте, сколько раз оно встречалось в этом тексте ранее.

Формат ввода

Вводится текст.
Формат вывода

Выведите ответ на задачу.
 */
public class WordsRepeatCount {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/spaikk/Рабочий стол/Java/test.txt"))) {
            Map<String, Integer> res = new HashMap<>();
            List<String> lines = br.lines().flatMap(a -> Stream.of(a.split("\\s")))
                    .collect(Collectors.toList());
            StringJoiner sj = new StringJoiner(" ");
            for (String s : lines){
                res.merge(s, 0, (a, b) -> a + 1);
                sj.add(String.valueOf(res.get(s)));
            }
            System.out.println(sj);
        }
    }
}
