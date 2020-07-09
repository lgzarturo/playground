import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LambdaFunctions {

    public static void main(String[] args) {
        int[] numbers = new int[] {1,26,172,51,216,12,62,10,46,3,2,8};
        final Integer[] greaterThan = filterGreaterThan(10, numbers);
        System.out.println("Función filterGreaterThan");
        System.out.println(Arrays.toString(greaterThan));
        System.out.println("Función filterGreaterThanLambda");
        System.out.println(Arrays.toString(filterGreaterThanLambda(10, numbers)));
        System.out.println("Función filterGreaterThanLambda Interfaz");
        System.out.println(Arrays.toString(filterGreaterThanLambda(numbers, number -> number > 52)));
        System.out.println("Función lambda para convertir tipos de dato");
        List<String> elements = Arrays.asList("12", "20", "15", "68", "88", "37");
        final IntStream intStream = elements.stream().mapToInt(Integer::valueOf);
        System.out.println(Arrays.toString(intStream.toArray()));

        int number = 9;
        final Function<Integer, Integer> addTwoNumbers = paramNumber -> number + paramNumber;
        System.out.println(addTwoNumbers.apply(9));

        final BiFunction<Integer, Integer, Integer> multiplyTwoNumbers = (param1, param2) -> param1 * param2;
        System.out.println(multiplyTwoNumbers.apply(9, 9));

        final Supplier<String> supplier = () -> "Hello";
        final Consumer<String> consumer = element -> System.out.println("Hello " + element);
        final Function<String, String> upperCase = String::toUpperCase;
        consumer.accept(upperCase.apply(supplier.get()));

        List<String> words = Arrays.asList("lowercase", "dos", "tres", "hola mundo", null);
        words.forEach(element -> System.out.println(Optional
                .ofNullable(element)
                .map(String::toUpperCase)
                .orElseThrow(() -> new IllegalArgumentException("El valor no puede ser nulo")))
        );
    }

    public static int[] filterGreaterThanLambda(int value, int[] array) {
        return Arrays.stream(array).filter(number -> number > value).toArray();
    }

    public static int[] filterGreaterThanLambda(int[] array, GreaterThan greaterThan) {
        return Arrays.stream(array).filter(greaterThan::apply).toArray();
    }

    public static Integer[] filterGreaterThan(int value, int[] array) {
        List<Integer> greaterNumbers = new ArrayList<>();
        for (int number : array) {
            if (number > value) {
                greaterNumbers.add(number);
            }
        }
        return greaterNumbers.toArray(new Integer[greaterNumbers.size()]);
    }

    interface GreaterThan {
        boolean apply(int number);
    }
}
