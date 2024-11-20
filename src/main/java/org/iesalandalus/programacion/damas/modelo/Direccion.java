package org.iesalandalus.programacion.damas.modelo;

//Esta clase representa las direcciones en las que pueden moverse las damas:

public enum Direccion {
    NORESTE ("Noreste"),    //Moviemiento hacia ARRIBA y a la DERECHA.
    SURESTE ("Sureste"),    //Movimiento hacia ABAJO y a la DERECHA.
    NOROESTE ("Noroeste") ,  //Moviemiento hacia ARRIBA y a la IZQUIERDA.
    SUROESTE ("Suroeste"); //Movimiento hacia ABAJO y a la IZQUIERDA.

    //ATRIBUTOS:
    private String cadenaAMostrar;

    //CONSTRUCTOR parametrizado:
    private Direccion(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    //Sobrescribo el método toString.
    @Override
    public String toString(){
        return cadenaAMostrar;
    }

}
