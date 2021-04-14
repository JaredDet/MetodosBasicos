package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        System.out.println(entradaInt());
    }

    //Metodo que crea una entrada de String

    public static String entradaString(){

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese entrada");
        
        String entrada = teclado.nextLine();

            return entrada;
    }

    //Metodo que crea una entrada de entero

    public static int entradaInt(){

        int entrada = 0;

        try{

            entrada = Integer.parseInt(entradaString());
        }

        catch(NumberFormatException ex){

            System.out.println("¡Error!");
            
            entrada = entradaInt();
        }
        return entrada;
    }
}
