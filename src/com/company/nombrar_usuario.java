package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nombrar_usuario {

    //Metodo que crea una entrada de String

    public static String entradaString() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese entrada");

        return teclado.nextLine();
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
}
