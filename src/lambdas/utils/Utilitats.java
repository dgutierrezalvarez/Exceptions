package lambdas.utils;

import lambdas.Persona;

import java.util.List;
import java.util.function.Consumer;

public class Utilitats {

    public static void imprimir(Persona p) {
        System.out.println("<=== " + p + " ===>");
    }

    public static void printPerson(List<Persona> llista, Consumer<Persona> c) {
        for(Persona a: llista) {
            c.accept(a);
        }
    }
}
