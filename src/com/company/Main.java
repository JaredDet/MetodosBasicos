package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {

        System.out.println(crearRut());
    }

    //Metodo que crea una entrada de String

    public static String entradaString() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese entrada");

        String entrada = teclado.nextLine();

        return entrada;
    }

    //Metodo que crea una entrada de entero

    public static int entradaInt() {

        int entrada = 0;

        try {

            entrada = Integer.parseInt(entradaString());
        } catch (Exception exception) {

            System.out.println("¡Error!");

            entrada = entradaInt();
        }
        return entrada;
    }

    //Metodo que valida que dicho nombre de usuario sea válido

    public static boolean validarUsuario(String usuario) {

        Pattern pat = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{7,29}$");
        Matcher mat = pat.matcher(usuario);
        return mat.find();
    }

    //Metodo que crea un nombre de usuario de entre 8 y 30 caracteres

    public static String nombrarUsuario() {

        String usuario = entradaString();

        if (!(validarUsuario(usuario))) {

            System.out.println("Usuario no válido");
            nombrarUsuario();
        }

        return usuario;
    }

    //Metodo que valida que dicho rut esté bien escrito

    public static boolean validarRut(String rut) {

        Pattern pat = Pattern.compile("^[0-9]{1,2}\\.{0,1}[0-9]{3}\\.{0,1}[0-9]{3}[-]{0,1}[0-9-kK]$");
        Matcher mat = pat.matcher(rut);
        return mat.find();
    }

    //Metodo que valida el verificador rut

    public static boolean validarVerificador(String rut){

        int j = 2;

        int verificador = 0;

        for(int i = rut.length()-2; i > -1; i--){

            if(j > 7){

                j = 2;
            }

            verificador += Integer.parseInt(String.valueOf(rut.charAt(i))) * j;

            j++;

        }


        verificador =  (11 - Math.abs(verificador / 11 * 11 - verificador));

        if(rut.charAt(rut.length()-1) == 'k' && verificador == 10){

            return true;
        }else if (rut.charAt(rut.length()-1) == '0' && verificador == 11){

            return true;
        }

        return verificador == Integer.parseInt(String.valueOf(rut.charAt(rut.length()-1)));

    }

    //Metodo que crea un rut

    public static String crearRut() {

        String rut = entradaString();

        if (!(validarRut(rut))) {

            System.out.println("Rut no válido");
            nombrarUsuario();
        }

        rut = rut.replace(".", "");
        rut = rut.replace("-", "");

        if(!(validarVerificador(rut.toLowerCase()))){

            System.out.println("Rut no válido");
            nombrarUsuario();
        }

        return "rut válido";
    }

    //Metodo que crea un menu

    public static void crearMenu() {

        ArrayList<String> menu = new ArrayList<String>(8);

        menu.add("Bienvenido");
        menu.add("----------------------");
        menu.add("Elija la operacion a realizar");
        menu.add("----------------------");
        menu.add("[1] Operacion 1");
        menu.add("[2] Operacion 2");
        menu.add("[3] Operacion 3");
        menu.add("[4] Operacion 4");

    }
    //Metodo que revisa si el año es o no biciesto

    public static void verificarAño(int año) {

        if (año % 4 == 0 || año % 400 == 0 && año % 100 != 0) {
            System.out.println("Año bisiesto");
            return;
        }
        System.out.println("Año no " +
                "bisiesto");
        return;
    }


    //Metodo que elimina las tildes, comas, espacios, etc

    public static String eliminarSpeChar(String palabra) {

        String spechar = "áéíóú";
        String chara = "aeiou";
        String signos = "¡!¿?.,;:'";

        for (int i = 0; i < spechar.length(); i++) {

            palabra = palabra.replace(spechar.charAt(i), chara.charAt(i));
        }

        for (int i = 0; i < signos.length(); i++) {

            palabra = palabra.replace(signos.charAt(i), ' ');
        }

        palabra = palabra.replace(" ", "");

        return palabra;
    }

    //Metodo que verifica que palabra es un palíndromo

    public static void verificarPalindromo() {

        String palabra = entradaString();
        palabra = eliminarSpeChar(palabra);

        StringBuilder palindromo = new StringBuilder(palabra.toLowerCase());

        if (palindromo.toString().equals(palindromo.reverse().toString())) {

            System.out.println("Es un palíndromo");
            return;
        }
        System.out.println("No es palíndromo");
    }

    //Metodo que verifica si es par o impar

    public static void verificarParoImpar(int numero) {

        if (numero % 2 == 0) {

            System.out.println("Es par");
            return;
        }
        System.out.println("Es impar");
    }

    //Metodo que verifica que un número sea primo

    public static boolean verificarPrimo(int primo) {

        int contador = 2;

        do {

            if (primo == 2) {

                return true;
            }

            if (primo % contador == 0 || primo == 0 || primo == 1) {

                return false;
            }
            contador++;

        } while (contador < primo);

        return true;
    }

    //Generar primos

    public static ArrayList<Float> generarPrimos() {

        float numero = entradaInt();

        ArrayList<Float> primos = new ArrayList<>();

        primos.add(numero);

        for (int i = 1; i < numero / 2; i++) {

            if (verificarPrimo(i)) {

                primos.add(Float.valueOf(i));
            }

        }
        return primos;
    }

    //calcular las potencias asociadas

    public static void calcularPotencias() {

        ArrayList<Float> primos = generarPrimos();

        for(int i = 1; i < primos.size(); i++){

            primos.set(i, (float) (Math.log10(primos.get(0))/Math.log10(primos.get(i))));
        }

        primos.remove(0);

        System.out.println(primos);
    }
}


