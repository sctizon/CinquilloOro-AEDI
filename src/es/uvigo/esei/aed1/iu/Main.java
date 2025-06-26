package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Juego;

public class Main {

    public static void main(String[] args) {
        IU iu = new IU();//Crea nueva interfaz
        Juego cinquillo = new Juego(iu);//Crea nuevo juego
        cinquillo.jugar();//Comienza el juego
    }
}
