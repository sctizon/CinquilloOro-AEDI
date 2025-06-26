/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */
package es.uvigo.esei.aed1.core;

import java.util.*;

public class Baraja {
    private Stack<Carta> baraja;

    public Baraja() {
        baraja = new Stack<>();
        crearBaraja();
        barajar(baraja);
    }

    /**
     * Crea una baraja de 4 palos, cada uno con 12 cartas
     *
     * @return Devuelve un Stack de Carta
     */
    private Stack<Carta> crearBaraja() {
        // Creamos cartas de Oros y añadimos a la baraja
        Carta oros;
        for (int i = 0; i < 12; i++) {
            oros = new Carta(i + 1, "Oros");
            baraja.add(oros);
        }
        // Creamos cartas de Copas y añadimos a la baraja
        Carta copas;
        for (int i = 0; i < 12; i++) {
            copas = new Carta(i + 1, "Copas");
            baraja.add(copas);
        }
        // Creamos cartas de Espadas y añadimos a la baraja
        Carta espadas;
        for (int i = 0; i < 12; i++) {
            espadas = new Carta(i + 1, "Espadas");
            baraja.add(espadas);
        }
        // Creamos cartas de Bastos y añadimos a la baraja
        Carta bastos;
        for (int i = 0; i < 12; i++) {
            bastos = new Carta(i + 1, "Bastos");
            baraja.add(bastos);
        }
        // Se devuelve la baraja
        return baraja;
    }

    /**
     * Mezcla las cartas de la baraja
     *
     * @param baraja Stack de Carta de donde se sacan las cartas a mezclar
     * @return Devuelve un Stack de Carta
     */
    private Stack<Carta> barajar(Stack<Carta> baraja) {
        // Crear un array de cartas que sirva de ayuda para barajar las cartas
        Carta[] barajaAux = new Carta[48];
        Random random = new Random();

        while(!baraja.isEmpty()) {
            int posicion = random.nextInt(48); //Seleccionar una posición aleatoria utilizando random          
            if (barajaAux[posicion] == null) // Si la posición está vacía, se coge la primera carta de la baraja y se inserta
            {
                barajaAux[posicion] = baraja.pop();
            }
        }
        
        for(Carta barajaAux1 : barajaAux) {
            baraja.add(barajaAux1); // Mover las cartas barajadas a la pila de cartas
        }
        return baraja; // Devolver la baraja       
    }

    /**
     * Devuelve la primera carta de la baraja.
     *
     * @return Devuelve un objeto de tipo Carta
     */
    public Carta cogerCarta() {
        return baraja.pop();
    }

    /**
     * Devuelve el número de cartas de la baraja.
     *
     * @return Devuelve un entero
     */
    public int getNumCartas() {
        return baraja.size();
    }

    /**
     * Permite conocer si la baraja está vacía
     *
     * @return Devuelve un boolean
     */
    public boolean esVacio() {
        return baraja.isEmpty();
    }

    /**
     * Transforma todos los datos de la baraja en un solo String
     *
     * @return Devuelve un String
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        while (!baraja.isEmpty()) {
            toret.append(baraja.pop());
        }
        return toret.toString();
    }
}
