/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.*;

public class Juego {
    private final IU iu;
    // baraja
    // jugadores

    public Juego(IU iu) {
        this.iu = iu;

    }

    public void jugar() {
        Baraja baraja = new Baraja();
        //System.out.println(baraja.toString());

        // Obtener número de jugadores
        int numJugadores;
        do {
            numJugadores = iu.leeNum("¿Cuantas personas van a jugar? ");
        } while (numJugadores < 3 || numJugadores > 4);

        // Crear jugadores y almacenar en un array
        Jugador[] jugadores = new Jugador[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            String nombre = iu.leeString("Introduce el nombre: ");
            Jugador nuevo = new Jugador(nombre);
            jugadores[i] = nuevo;
        }

        // Repartir cartas entre los jugadores
        int numCartasMano = baraja.getNumCartas() / numJugadores;
        for (int i = 0; i < numJugadores; i++) {
            for (int j = 0; j < numCartasMano; j++) {
                Carta carta = baraja.cogerCarta();
                jugadores[i].añadirCartaMano(carta);
            }
        }

        // Mostrar nombre y cartas (estado de los jugadores)
        iu.mostrarJugadores(jugadores);

        // Indicar el jugador (al azar) que empieza la partida
        Random random = new Random();
        int pos = random.nextInt(numJugadores);
        System.out.println("Empieza a jugar: " + jugadores[pos].getNombre());

    }
}
