package application.controller;

import application.model.Lommeregner;

public class Controller {
    private Lommeregner lommeregner;

    public Controller() {
        lommeregner = new Lommeregner();
    }

    public double udregnAddition (double tal1, double tal2){
        double sum = lommeregner.addition(tal1,tal2);
        return sum;
    }

    public double udregnSubtraktion (double tal1, double tal2){
        double sum = lommeregner.subtraktion(tal1,tal2);
        return sum;
    }

    public double udregnDivision (double tal1, double tal2){
        double sum = lommeregner.division(tal1,tal2);
        return sum;
    }

    public double udregnMultiplikation (double tal1, double tal2){
        double sum = lommeregner.multiplikation(tal1,tal2);
        return sum;
    }
}

