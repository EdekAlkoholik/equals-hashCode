package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // metody hashCode i Equals jeśli nie są nadpisane wykonają się z klasy object
        // public native int hashCode()
        // natywna funkcja używana przez jvm do której nie mamy bezpośrednio dostępu

        // equals zwraca wartość typu boolean
        // public boolean equals(Object obj) { return (this == obj); }
        // == porównuje zmienne referencyjne
        // nieważne są wartości pól obiektów, a jedynie zmienne jakie je reprezentują

        // objectIdentity - wiecej niż jedna zmienna wskazuje na dany obiekt

        Cat cat1 = new Cat("Susie", 3);
        // jvm alokuje miejsce na nowy obiekt cat1 i umieszcza go na stosie

        Cat cat2 = cat1; // przypisanie do zmiennej referencyjnej cat1
        // nie tworzymy nowego obiektu, cat2 jest jak wskaźnik do cat1

        System.out.println(cat1 == cat2);   // bazowe wykorzystanie metody equals, zwróci true


        // objectEquality -zależy od logiki biznesowej

        // kontrakt equals:
        //  - reflexive     dla każdej nie nullowej referencji a.equals(a) powinno zwracać true.
        //  - symmetric     dla każdej nie nullowej referencji a.equals(b) powinno zwracać true
        //                  tylko wtedy gdy b.equals(a).
        //  - transitive    dla kazdej nie nullowej referencji a.equals(b) zwraca true i
        //                  b.equals(c) zwraca true, to a.equals(c) również powinno zwracać true.
        //  - consistent    dla kazdej nie nullowej referencji a i b, powinno za każdym razem zwracać true
        //                  lub za każdym razem zwracać false, o ile obiekty nie zostały zmienione.
        //  -               dla każdej nie nullowej referencji a.equals(null) powinno zwracać false.


        // kontrakt hashCode:
        //  1   Podczas działania danej instancji aplikacji Java, metoda hashCode wywoływana na danym obiekcie
        //      musi zwracać ciągle tą samą wartość, o ile obiekt nie uległ zmianie.
        //  2   Jeśli dla dwóch obiektów metoda equals zwraca true, to metoda hashCode musi dla tych samych obiektów
        //      zwracać tę samą wartość.
        //  3   Jeśli wywołana na dwóch obiektach metody equals zwraca false, to nie jest wymagane aby metoda
        //      hashCode zwracała różne wartości, zwrócenie różnych wartości będzie miało pozytywny wpływ na wydajność
        //      w użyciu hash tables.

        Cat janna = new Cat("Janna", 2);
        Cat neeko = new Cat("Neeko", 3);
        Cat nami = new Cat("Nami", 1);

        Map<Cat, String> catsOwnerMap = new HashMap<>();

        catsOwnerMap.put(janna, "Edek");
        catsOwnerMap.put(neeko, "Aga");
        catsOwnerMap.put(nami, "Pyke");

        System.out.println(janna.hashCode());
        System.out.println(neeko.hashCode());
        System.out.println(nami.hashCode());

        System.out.println(catsOwnerMap.get(janna));

        /*
         kolekcie hashTable działają w systemie kubełkowym
         przy dodawaniu obiektu wyliczany jest jego hashCode, sprawdzane jest czy istnieje kubełek oznaczony tym
         hashcodem, jeśli nie to do pierwszego wolnego wrzucany jest ten obiekt, dany kubełek oznaczany jest
         właśnie tym hashCodem, przy dodawaniu kolejnego ponownie.
         jeśli mamy 4 obiekty z tym samym hashCodem wszystkie będą w jednym kubełku, degradacja do LinkListy
         dla wielu elementów to będzie duży problem, bo przy wyszukiwaniu obiektu z kilku tyś za każdym razem
         system będzie musiał porównać wszystkie żeby znaleść jeden
         gdy kilka obiektów w kubełku są rozpoznawane przy pomocy metody equals
        */


        // jeśli nadpiszemy equals() w danej klasie to musimy nadpisać też hashCode !

        Cat cat6 = new Cat("Annah", 3);
        Cat cat7 = new Cat("Annah", 3);

        System.out.println("==============");
        System.out.println(cat6.equals(cat7));
        //System.out.println(cat6.hashCode());
        //System.out.println(cat7.hashCode());

        Map<Cat, String> catStringMap = new HashMap<>();
        catStringMap.put(cat6, "value 1");
        catStringMap.put(cat7, "value 2");

        System.out.println(catStringMap.get(cat6)); // zwraca value 2
        System.out.println(catStringMap.get(cat7));
        // przy dodawaniu drugiego obiektu dodało na podstawie hashCode, obiekty takie same więc nadpisało
        // gdybyśmy nie nadpisali metody hashCode byłyby różne
        // jak napisujemy equals musimy nadpisać też hashCode !
    }
}
