package lambdas;

import java.time.LocalDate;
import java.time.Period;

public class Persona implements Comparable<Persona> {

    private String nom;
    private Genere genere;
    private LocalDate dataNaixament;

    public enum Genere {
        HOME,DONA;
    }

    public Persona(String nom, Genere genere, LocalDate dataNaixament) {
        this.nom = nom;
        this.genere = genere;
        this.dataNaixament = dataNaixament;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Genere getGenere() {
        return genere;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public LocalDate getDataNaixament() {
        return dataNaixament;
    }
    public void setDataNaixament(LocalDate dataNaixament) {
        this.dataNaixament = dataNaixament;
    }

    /*
     *	@return int Edat de la persona a partir de la data de naixament
     */

    public int getAge() {
        LocalDate today = LocalDate.now();
        if ((dataNaixament != null) && (today != null)) {
            return Period.between(dataNaixament, today).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Persona o) {
        if(getAge() > o.getAge()) return -1;
        else if(getAge() < o.getAge()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return nom + '\t' + genere.toString() + '\t' + getAge();
    }



}


