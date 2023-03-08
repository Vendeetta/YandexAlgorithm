package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Во входном файле (вы можете читать данные из sys.stdin, подключив библиотеку sys) записан текст.
Словом считается последовательность непробельных символов идущих подряд,
слова разделены одним или большим числом пробелов или символами конца строки.
Определите, сколько различных слов содержится в этом тексте.
Формат ввода

Вводится текст.
Формат вывода

Выведите ответ на задачу.
 */
public class NumberOfUniqWords {

    public static void main(String[] args) throws IOException {

        List<String> strings = Files.readAllLines(Path.of("/home/spaikk/Рабочий стол/Java/test.txt"));
        String str = strings.stream()
                .map(a -> a.replaceAll("[\\,\\.\\?\\!\\:\\;]", ""))
                .collect(Collectors.joining(" "));
        System.out.println(new HashSet<>(List.of(str.split(" "))).size());

    }
}
