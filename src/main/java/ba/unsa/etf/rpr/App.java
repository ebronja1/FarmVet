package ba.unsa.etf.rpr;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        MedicinesDao dao = new MedicinesDaoSQLImpl();

        Animals animal = new Animals();
        animal.setId(2);
        animal.setName("Milka");
        ArrayList<Medicines> medicinesByAnimals = new ArrayList<Medicines>(dao.searchByAnimals(animal));
        System.out.println("Treba ispisati 1 lijek po ovoj zivotinji: ");
        medicinesByAnimals.forEach(m -> System.out.println(m.getName()));

    }
}