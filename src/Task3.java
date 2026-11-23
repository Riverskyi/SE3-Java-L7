import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static String sortNumbers(String[] values) {
        return Arrays.stream(values)
                .flatMap(value -> Arrays.stream(value.split(",")))
                .map(value -> Integer.parseInt(value.trim()))
                .sorted()
                .map(number -> number.toString())
                .collect(Collectors.joining(", "));
    }
}
