import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alex", "Ivan", "Maria", "Peter", "Kate");

        System.out.println("Завдання 1:");
        System.out.println(Task1.getOddIndexedNames(names));

        System.out.println("\nЗавдання 2:");
        System.out.println(Task2.sortUppercase(names));

        System.out.println("\nЗавдання 3:");
        String[] numbers = {"1, 2, 0", "4, 5"};
        System.out.println(Task3.sortNumbers(numbers));

        System.out.println("\nЗавдання 4 (перші 10 чисел):");
        long a = 25214903917L;
        long c = 11L;
        long m = 1L << 48;
        List<Long> randomNumbers = Task4.generate(a, c, m)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(randomNumbers);

        System.out.println("\nЗавдання 5:");
        Stream<String> first = Stream.of("A", "B", "C");
        Stream<String> second = Stream.of("1", "2");
        List<String> mixed = Task5.zip(first, second)
                .collect(Collectors.toList());
        System.out.println(mixed);
    }
}
