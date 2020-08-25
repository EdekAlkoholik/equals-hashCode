package com.company;

public class Cat {

    private String name;
    private int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override                                   // poprawna implementacja metody equals
    public boolean equals(Object object){
        if(this == object) {
            return true;
        }
        if(object == null) {
            return false;
        }
        if(object instanceof Cat){

            Cat o = (Cat) object;
            if(name.equals(o.name) && age == o.age){
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*
    @Override                   // najgorsza możliwa implementacja hashCode
    public int hashCode(){
        return 1;
    }
    */

    @Override
    public int hashCode() {
        int result = 7;                         // wpisujemy dowolną liczbę pierwszą, następnie po kolei pola
        result = 31 * result + name.hashCode(); // implementacja metody z klasy String
        result = 31 * result + age;
        return result;                          // i tak wygląda poprawna metoda hashCode
    }                                           // 7 i 31 liczby pierwsze dają najmniej kolizji kodów, hashy
    // dodatkowo operacja mnożenia *31 to dla komputera operacja przesunięcia bitowe i odejmowania
    // kazdy obiekt w hashMapie otrzyma swój kubełek, program szybciej wyszuka konkretny rekord z mapy

    // jeśli nadpiszemy equals() w danej klasie to musimy nadpisać też hashCode !

    // ide może samo nadpisać te metody dla nas
    // intellij: alt + insert -> equals() and hashCode()



}
