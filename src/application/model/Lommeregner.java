package application.model;

public class Lommeregner {

    public double addition (double tal1, double tal2){
        double sum = tal1 + tal2;
        return sum;
    }

    public double subtraktion (double tal1, double tal2){
        double sum = tal1 - tal2;
        return sum;
    }

    public double division (double tal1, double tal2){
        if(tal2 == 0){
            throw new ArithmeticException("Division med nul er ikke tilladt");
        }
        double sum = tal1 / tal2;
        return sum;
    }

    public double multiplikation (double tal1, double tal2){
        double sum = tal1 * tal2;
        return sum;
    }
}
