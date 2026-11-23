import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Task2 {
    public static List<String> sortUppercase(List<String> words) {
        return words.stream()
                .map(word -> word.toUpperCase(Locale.ROOT))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
