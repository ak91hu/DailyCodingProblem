public class SimplePair {
    interface Handler {
        int apply(int a, int b);
    }

    interface Pair {
        int useHandler(Handler h);
    }

    public static Pair cons(int a, int b) {
        return h -> h.apply(a, b);
    }

    public static int car(Pair pair) {
        return pair.useHandler((a, b) -> a);
    }

    public static int cdr(Pair pair) {
        return pair.useHandler((a, b) -> b);
    }

    public static void main(String[] args) {
        System.out.println(car(cons(3, 4)));
        System.out.println(cdr(cons(3, 4)));
    }
}
