package pocket;

public class Hello {
    public static void main(String[] args) {
        Function fn = (lower, upper) -> {
            final int i = lower;
            return (Function2) () -> {
                for (int j = i; j < upper; j += 2) {
                    System.out.println(j);
                }
            };
        };

        fn.exec(1, 100).exec();
    }
}

@FunctionalInterface
interface Function {
    Function2 exec(int lower, int upper);
}

@FunctionalInterface
interface Function2 {
    void exec();
}