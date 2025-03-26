package Reservas;

import java.util.ArrayList;
import java.util.List;

/**
* Clase que gestiona las reservas de pistas deportivas, incluyendo la creación de reservas,
* la cancelación, la activación y desactivación de la iluminación de las pistas,
* y la verificación de la disponibilidad de las pistas.
* 
* @author Yessenia Martinez
*/

public class Sistema {

    private List<Reservas> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Constructor que inicializa las reservas y las luces de las pistas.
     */
    
    public Sistema() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
    
    /**
     * Realiza una reserva para una pista en una fecha específica y duración dada.
     * 
     * @param reserva Objeto de tipo Reserva que contiene la pista, la fecha y la duración de la reserva.
     * @return true si la reserva se ha realizado correctamente, false si la pista ya está reservada.
     */

    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reservas(idPista, fecha, duracion));
        return true;
    }
    
    /**
     * Cancela una reserva existente basándose en el ID de la reserva.
     * 
     * @param idReserva El ID de la reserva a cancelar.
     * @return true si la reserva fue cancelada correctamente, false si no se encontró la reserva.
     */

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
    /**
     * Enciende las luces de una pista específica.
     * 
     * @param idPista El ID de la pista para encender las luces.
     * @return true si las luces se encendieron correctamente, false si el ID de la pista es inválido.
     */

    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }
    
    /**
     * Apaga las luces de una pista específica.
     * 
     * @param idPista El ID de la pista para apagar las luces.
     * @return true si las luces se apagaron correctamente, false si el ID de la pista es inválido.
     */

    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
    
    /**
     * Verifica la disponibilidad de una pista en una fecha y hora específica.
     * 
     * @param idPista El ID de la pista a verificar.
     * @param fecha La fecha en la que se desea verificar la disponibilidad.
     * @param hora La hora en la que se desea verificar la disponibilidad.
     * @return true si la pista está disponible, false si ya está reservada en esa fecha.
     */

    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}