package org.iesalandalus.programacion.damas.modelo;

//Esta clase representa los colores que puede tener una dama (BLANCO o NEGRO).

public enum Color {
    BLANCO ("Blanco"), //Damas de color BLANCO.
    NEGRO ("Negro");  //Damas de color NEGRO.

    //ATRIBUTOS:
    private String cadenaAMostrar;

    //CONSTRUCTOR parametrizado:
    private Color(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    //Sobrescribo el método toString.
    @Override
    public String toString(){
        return cadenaAMostrar;
    }
}
