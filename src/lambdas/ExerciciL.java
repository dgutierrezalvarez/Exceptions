package lambdas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ExerciciL {

    public static void main(String[] args) {
        //1,2
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992",format));
        Persona p9 = new Persona("Davos", Persona.Genere.HOME, LocalDate.parse("12/11/1965",format));
        Persona p10 = new Persona("Jon Neu", Persona.Genere.HOME, LocalDate.parse("12/11/1986",format));
        Persona p11 = new Persona("Brienne", Persona.Genere.DONA, LocalDate.parse("12/11/1989",format));

        //3
        Persona[] lpers = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11};
        List<Persona> llistaPersones;
        llistaPersones = new ArrayList<>(Arrays.asList(lpers));


        // 4 - TODO: Canviar a lambda
        System.out.println("\n4");
       /* Collections.sort(llistaPersones, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });
        */
        Collections.sort(llistaPersones,
                (o1, o2) -> {
                    if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                    else return -1;
                });



        // 5 - Canviar a Lambda
        for(Persona p: llistaPersones) {
            System.out.println(p);
        }

        // 6 - TODO: Canvia a classe anònima
        System.out.println("\n6");
        //ordenació alfabètica inversa del nom
        /* llistaPersones.sort((o1,o2) -> o2.getNom().compareTo(o1.getNom())); */

        llistaPersones.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o2.getNom().compareTo(o1.getNom());
            }
        });

        // 7 - Canvia per una crida al mètode per referència que hagis creat tu
        for(Persona p: llistaPersones) {
            System.out.println(p);
        };

        llistaPersones.forEach(lambdas.utils.Utilitats::imprimir);

        // 8 - Omplir map
        Map<Integer,Integer> mapPersones = new HashMap<>();
        System.out.println("8 - Map");
     /*   for(Persona per : llistaPersones) {
            if(!mapPersones.containsKey(per.getAge())) {
                mapPersones.put(per.getAge(), 1);
            } else {
                mapPersones.put(per.getAge(), mapPersones.get(per.getAge())+1);
            }
        }*/
    /*
       llistaPersones.forEach(persona -> {
           if ((!mapPersones.containsKey(persona.getAge())))
               mapPersones.put(persona.getAge(), 1);
           else mapPersones.put(persona.getAge(), mapPersones.get(persona.getAge()) + 1);
       });

    */

       llistaPersones.forEach(persona -> {
           mapPersones.computeIfPresent(persona.getAge(),(k,v) -> v + 1);
           mapPersones.putIfAbsent(persona.getAge(),1);

       });

        // 9 - Canvia per un recorregut forEach amb lambda
        System.out.println("\n9 Recorregut map");
        for(Map.Entry entry : mapPersones.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 10 - llistat de persones DONA amb stream
        System.out.println("\n10 DONES");
        llistaPersones.stream().filter(persona -> persona.getGenere().equals(Persona.Genere.DONA)).forEach(System.out::println);

        // 11 - Crea un List amb les persones més petites de 25 anys
        System.out.println("\n11 Menors de 25");
        List<Persona> menors25 = llistaPersones.stream().filter(p -> p.getAge() < 25).collect(Collectors.toList());
        menors25.forEach(System.out::println);

        // 12 - Persones que tinguin una 'a' al seu nom
        System.out.println("\n12 Amb una 'A'");
        llistaPersones.stream().filter(p -> p.getNom().toUpperCase().contains("A")).forEach(System.out::println);


        // 13 - Llistat dels dos HOMES més joves
        System.out.println("\n13 HOMES + JOVES");
        llistaPersones.stream()
                .filter(persona -> persona.getGenere().equals(Persona.Genere.HOME))
                .sorted(Comparator.comparing(Persona::getAge))
                .limit(2)
                .forEach(System.out::println);

        // 14 - Esborrar del llistat les persones entre 30 i 40 anys
        System.out.println("\n14");
        List<Persona> novallista = new ArrayList<>();
        llistaPersones.removeIf(persona -> persona.getAge()>30 && persona.getAge()<=40);
        llistaPersones.forEach(System.out::println);

        //15 - Llistat de les dates de naixament + dos dies
        System.out.println("\n15 - dates amb dos dies més");
        llistaPersones.stream().map(persona -> persona.getDataNaixament().plusDays(2)).forEach(System.out::println);

        //16
        System.out.println("\n16 - Rejovenir dos anys a totes les persones");
        llistaPersones.stream().
                map(persona -> {
                    persona.setDataNaixament(persona.getDataNaixament().plusYears(2));
                    return persona;
                })
        .forEach(System.out::println);


    }


}
