package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        validarEntrada();
    }

    //Metodo que crea una entrada

    public static int Entrada(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese entrada");

        String entrada = teclado.nextLine();

            return Integer.parseInt(entrada);
    }

    //Metodo que valida una entrada

    public static int validarEntrada(){

        int entrada = 0;
        try{
            entrada = Entrada();
        }
        catch(ExceptionInInitializerError){
            System.out.println("¡Error!");
            validarEntrada();
        }
        return entrada;
    }
}
