package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(StringPriceToCents(null));

    }

    private static int StringPriceToCents(String price) {
        if (price != null) {
            price =  price.replace("$","").replace(".","");
            System.out.println(price);
            if(price.matches("[0-9]+")) {
                System.out.println("it matches");
                return Integer.parseInt(price);
            }
        }
        return 0;
    }
}