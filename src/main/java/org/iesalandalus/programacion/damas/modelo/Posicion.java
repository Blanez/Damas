package org.iesalandalus.programacion.damas.modelo;

//Esta clase representa la posición de la dama en el tablero con una fila y una columna.

import java.util.Objects;

public class Posicion {

    //ATRIBUTOS:
    private int fila;   //Número de fila (1-8).
    private char columna;    //Letra de la columna (a-h).

    //CONSTRUCTOR parametrizado:
    public Posicion(int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }

    //CONSTRUCTOR COPIA:
    public Posicion(Posicion posicion){
        if(posicion == null){
            throw new NullPointerException("ERROR: No se puede copiar una posición nula."); //Lanza esta excepción si la posición dada no está dentro de los parámetros.
        }

        this.fila = posicion.fila;
        this.columna = posicion.columna;
    }

    //MÉTODOS GET y SET:
    public int getFila(){
        return fila;
    }

    public void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        this.columna = columna;
    }

    //Sobrescribe el método equals para comparar posiciones.
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Posicion other = (Posicion) obj;
        return fila == other.fila && columna == other.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    //Sobrescribe método tuString para devolver un texto.
    @Override
    public String toString() {
        return String.format("fila=%d, columna=%c", fila, columna);
    }

}
