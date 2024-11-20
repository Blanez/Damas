package org.iesalandalus.programacion.damas;

//Esta clase es la que interactúa con el usuario.

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    //Constructor vacío.
    private Consola() {
        // Esta clase es de utilidades, no requiere inicialización de atributos.
    }

    //Muestra el Menú Principal:
    public static void mostrarMenu() {
        System.out.println("----- MENÚ PRINCIPAL -----");
        System.out.println("1. Crear dama por defecto.");
        System.out.println("2. Crear dama eligiendo el color.");
        System.out.println("3. Mover dama.");
        System.out.println("4. Salir.");
        System.out.println("--------------------------");
    }

    //Solicita al usuario que elija una opción del Menú Principal:
    public static int elegirOpcionMenu() {
        int opcion;
        do {
            System.out.print("Elige una opción (1-4): ");
            opcion = Entrada.entero();
            if (opcion < 1 || opcion > 4) {
                System.out.println("ERROR: Opción no válida. Debes elegir entre 1 y 4.");
            }
        } while (opcion < 1 || opcion > 4); // Repite hasta que la opción sea válida.
        return opcion;
    }

    //Solicita al usuario que elija un color para la dama:
    public static Color elegirColor() {
        int opcion;
        do {
            System.out.println("Elige el color de la dama:");
            System.out.println("1. Blanco.");
            System.out.println("2. Negro.");
            System.out.print("Elige una opción (1-2): ");
            opcion = Entrada.entero(); // Leer la opción como entero.
            if (opcion < 1 || opcion > 2) {
                System.out.println("ERROR: Opción no válida. Debes elegir entre 1 y 2.");
            }
        } while (opcion < 1 || opcion > 2); //Repite hasta que la opción sea válida.

        //Devuelve el color basado en la opción elegida
        if (opcion == 1) {
            return Color.BLANCO;
        } else {
            return Color.NEGRO;
        }
    }

    //Muestra submenú con las posibles direcciones:
    public static void mostrarMenuDirecciones() {
        System.out.println("----- DIRECCIONES -----");
        System.out.println("1. Noreste.");
        System.out.println("2. Sureste.");
        System.out.println("3. Suroeste.");
        System.out.println("4. Noroeste.");
        System.out.println("-----------------------");
    }

    //Solicita al usuario que elija una dirección:
    public static Direccion elegirDireccion() {
        int opcion;
        do {
            mostrarMenuDirecciones();
            System.out.print("Elige una dirección (1-4): ");
            opcion = Entrada.entero(); //Leer la opción como entero.
            if (opcion < 1 || opcion > 4) {
                System.out.println("ERROR: Opción no válida. Debes elegir entre 1 y 4.");
            }
        } while (opcion < 1 || opcion > 4); //Repite hasta que la opción sea válida.

        //Devuelve la dirección basada en la opción elegida
        switch (opcion) {
            case 1:
                return Direccion.NORESTE;
            case 2:
                return Direccion.SURESTE;
            case 3:
                return Direccion.SUROESTE;
            case 4:
                return Direccion.NOROESTE;
            default:
                //No debería alcanzarse este punto debido a las comprobaciones anteriores.
                throw new IllegalStateException("ERROR: Dirección no válida.");
        }
    }

    //Solicita al usuario que elija el número de pasos:
    public static int elegirPasos() {
        int pasos;
        do {
            System.out.print("Introduce el número de pasos (mayor o igual a 1): ");
            pasos = Entrada.entero(); //Leer el número de pasos como entero.
            if (pasos < 1) {
                System.out.println("ERROR: El número de pasos debe ser mayor o igual a 1.");
            }
        } while (pasos < 1); //Repite hasta que el número de pasos sea válido.
        return pasos;
    }

    //Muestra mensaje de despedida:
    public static void despedirse() {
        System.out.println("Gracias por usar el juego. ¡Hasta la próxima!");
    }
}
