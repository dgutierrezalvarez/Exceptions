package lambdas;

public class Others {

}

@FunctionalInterface
interface CheckPerson {
    boolean check(Persona p);
    default void p() {
        System.out.println("default method");
    }

    default void p2() {
        System.out.println("d2");
    }
    static void s() {
        System.out.println("static method");
    }
}

@FunctionalInterface
interface Predicat<T> {
    boolean check(T p);

}

@FunctionalInterface
interface OpPerson {
    int operation(Persona p);
}

@FunctionalInterface
interface Predicat2<T,U> {
    boolean test(T t, U u);
}