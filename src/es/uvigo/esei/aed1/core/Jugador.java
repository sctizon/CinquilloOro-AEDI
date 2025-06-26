/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */
package es.uvigo.esei.aed1.core;

import java.util.*;

public class Jugador {
    private String nombre;
    private List<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }

//    public void setMano(List<Carta> mano) {
//        this.mano = mano;
//    }
    
    /**
     * Añade una carta a la mano
     *
     * @param carta Carta a añadir.
     */
    public void añadirCartaMano(Carta carta) {
        mano.add(carta);
    }

    /**
     * Transforma todos los datos del jugador en un solo String
     *
     * @return Devuelve un String
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append("\n").append(nombre).append("\n");
        for (Carta carta : mano) {
            toret.append("\t").append(carta.toString());
        }
        return toret.toString();
    }
}
