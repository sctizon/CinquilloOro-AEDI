/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IU {
    private final Scanner teclado;
    
    public IU() {
        teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un número de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return Devuelve un entero
     */
    public int leeNum(String msg) {
        do {
            System.out.print(msg);

            try {
                return teclado.nextInt();
            } catch (InputMismatchException exc) {
                teclado.next();
                System.out.println("Entrada no válida. Debe ser un entero.");
            }
        } while (true);
    }

    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }

    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
    }

//    public Collection<String> pedirDatosJugadores(){
//
//
//
//    }
    
    /**
     * Muestra los datos de un jugador por pantalla.
     *
     * @param jugador El jugador a visualizar.
     */
    public void mostrarJugador(Jugador jugador) {
        System.out.println(jugador.toString());
    }

//    public void mostrarJugadores(Collection<Jugador> jugadores){
//
//    }
    
    /**
     * Muestra los datos de todos los jugadores por pantalla.
     *
     * @param jugadores Devuelve un Array de Jugador
     */
    public void mostrarJugadores(Jugador[] jugadores) {
        for(int i = 0; i < jugadores.length; i++) {
            mostrarJugador(jugadores[i]);
        }
    }
}
