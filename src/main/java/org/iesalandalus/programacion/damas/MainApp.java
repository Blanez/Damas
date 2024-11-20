package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Color;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    private static Dama dama;

    public static void main(String[] args) {
        int opcion;

        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);

        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                System.out.println("Saliendo de la aplicación...");
                break;
            default:
                throw new IllegalArgumentException("ERROR: Opción no válida.");
        }
    }

    private static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Dama creada por defecto.");
        mostrarDama();
    }

    private static void crearDamaColor() {
        Color color = Consola.elegirColor();
        dama = new Dama(color);
        System.out.println("Dama creada con color " + color + ".");
        mostrarDama();
    }

    private static void mover() {
        if (dama == null) {
            System.out.println("ERROR: No hay ninguna dama creada.");
        } else {
            Consola.mostrarMenuDirecciones();
            Direccion direccion = Consola.elegirDireccion();

            int pasos = 1;
            if (dama.isEsDamaEspecial()) {
                pasos = Consola.elegirPasos();
            }

            try {
                dama.mover(direccion, pasos);
                System.out.println("La dama ha sido movida correctamente.");
                mostrarDama();
            } catch (Exception e) {
                System.out.println("ERROR: No se pudo mover la dama. " + e.getMessage());
            }
        }
    }

    private static void mostrarDama() {
        if (dama == null) {
            System.out.println("No hay ninguna dama creada.");
        } else {
            System.out.println(dama);
        }
    }
}


