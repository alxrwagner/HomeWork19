import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        System.out.println();

        //task5
        Predicate<String> predicate = String::isBlank;
        Function<String, Integer> isTrue = str -> -1;
        Function<String, Integer> isFalse = String::length;

        System.out.println(ternaryOperator(predicate, isTrue, isFalse).apply("Жельнемекельбещ"));
    }

    public static void task1() {
        System.out.println("TASK1");
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate.test(4));
        System.out.println(predicate.test(-4));
        System.out.println("_______________________");

        Predicate<Integer> predicate1 = integer -> integer > 0;

        System.out.println(predicate1.test(2));
        System.out.println(predicate1.test(-2));
    }

    public static void task2() {
        System.out.println("TASK2");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello " + s);
            }
        };
        consumer.accept("Ivan");

        Consumer<String> consumer1 = s -> System.out.println("Hello " + s);
        consumer1.accept("Lolita");
    }

    public static void task3() {
        System.out.println("TASK3");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        System.out.println(function.apply(311.43534));

        Function<Double, Long> function1 = Math::round;
        System.out.println(function1.apply(45.234242));
    }

    public static void task4() {
        System.out.println("TASK4");
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(supplier.get());
        System.out.println("_______________________");

        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println(supplier1.get());
    }

    public static void task5() {
        System.out.println("TASK5");


    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return obj -> condition.test(obj) ? ifTrue.apply(obj) : ifFalse.apply(obj);
    }
}