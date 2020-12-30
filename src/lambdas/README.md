### Exercicis Lambda i streams

1. Definir la variable _**format**_ per instaciar els objectes del punt 2 (DateTimeFormatter) 
2. Crear: 
    ```java
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

    ```

3. Crear un ArrayList d'aquestes persones (llistaPersones)
4. Canvia el següent codi per una expressió lambda:
    ```java
    Collections.sort(llistaPersones, new Comparator<Persona>() {
                @Override
                public int compare(Persona o1, Persona o2) {
                    if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                    else return -1;
                }
            });
    ```
5. Canvia el següent codi per una expressió lambda:
    ```java
    for(Persona p: llistaPersones) {
        System.out.println(p);
    }
    ```
6. Transforma la lambda en una classe anònima:
    ```java
    //ordenació alfabètica inversa del nom
    llistaPersones.sort((o1,o2) -> o2.getNom().compareTo(o1.getNom()));
    ```
7. Crea un _Reference Method_ i utilitza'l per imprimir totes les persones de la Collection amb __foreach__
    ```java
   //substituir pel foerech amb el reference method 
   for(Persona p: llistaPersones) {
               System.out.println(p);
   } 
   ```
8. Crea un *Map de Persona* on la **key** és l'edat i el **value** és _quantes perones hi ha amb aquesta edat_.
Esbrina com fer els puts al map usant aquests mètodes **computeIfPresent** i **putIfAbsent**

9. Fes un recorregut per imprimir clau i valor del map, amb foreach i una lambda o reference method.

10. Treu un llistat de les persones DONA. Cal fer servir STREAM.

11. Crea un List amb els menors de 25 (stream)

12. Llistat de Persones que tinguin una 'a' o 'A' al seu nom (stream)

13. Treu un llistat dels 2 HOMES més joves. (stream)

14. Esborrar del llistat les persones entre 30 i 40 anys (removeIf)

15. Llistat de totes les dates de naixament suman-t'hi dos dies (no cal actualitzar la data de les persones, només treure el calcul)

16. Rejovenir 2 anys a totes les persones. Que a totes les persones els quedi actualitzada la nova data de naixament (stream)



 