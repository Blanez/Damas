package org.iesalandalus.programacion.damas.modelo;

//Esta clase representa una dama con color, posición y movimiento.

import java.util.Random;

public class Dama {

    //ATRIBUTOS:
    private Color color;         //Color de la dama (BLANCO o NEGRO).
    private Posicion posicion;   //Posición actual de la dama.
    private boolean esDamaEspecial; //Indica si la dama es especial (ha llegado al extremo opuesto).

    //CONSTRUCTOR vacío (crea una dama en su posición inicial):
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(Color.BLANCO);
        this.esDamaEspecial = false;
    }

    //CONSTRUCTOR parametrizado (este permite especificar el color de la dama):
    public Dama(Color color) {
        //Verificar que el color no sea nulo
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }

        this.color = color;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;

    }

    //MÉTODOS GET y SET:
    public Color getColor() {
        return color;
    }

    public Posicion getPosicion() {
        return new Posicion(posicion);
    }

    private void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("ERROR: El color no puede ser nulo.");
        }
        this.color = color;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("ERROR: La posición no puede ser nula.");
        }
        this.posicion = new Posicion(posicion);
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    private Posicion crearPosicionInicial(Color color) {
        Random random = new Random();
        int fila;
        char columna;

        do {
            fila = color == Color.BLANCO ? random.nextInt(3) + 1 : random.nextInt(3) + 6;
            columna = (char) ('a' + random.nextInt(8));
        } while ((fila + columna) % 2 == 0); // Solo casillas negras

        return new Posicion(fila, columna);
    }

    public void mover(Direccion direccion, int pasos) {
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if (pasos < 1) {
            throw new IllegalArgumentException("ERROR: El número de pasos debe ser al menos 1.");
        }

        //Determina la nueva posición según la dirección.
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        switch (direccion) {
            case NORESTE -> { nuevaFila++; nuevaColumna++; }
            case SURESTE -> { nuevaFila--; nuevaColumna++; }
            case SUROESTE -> { nuevaFila--; nuevaColumna--; }
            case NOROESTE -> { nuevaFila++; nuevaColumna--; }
        }

        //Verifica que la nueva posición esté dentro del tablero.
        if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
            throw new IllegalArgumentException("ERROR: Movimiento no válido. La dama se sale del tablero.");
        }

        posicion = new Posicion(nuevaFila, nuevaColumna);

        //Si llega al extremo opuesto, se convierte en dama especial.
        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            esDamaEspecial = true;
        }
    }



    @Override
    public String toString() {
        return String.format("Dama [color=%s, posicion=%s, esDamaEspecial=%b]", color, posicion, esDamaEspecial);
    }


}
