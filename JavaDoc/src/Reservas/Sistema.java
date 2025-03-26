package Reservas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las reservas de pistas deportivas, incluyendo la creación de reservas,
 * la cancelación y la verificación de la disponibilidad de las pistas.
 * 
 * @author Yessenia Martinez
 */
public class Sistema {
    
    private List<Reservas> reservas;
    private GestorIluminacion gestorIluminacion;
    private static final int MAX_PISTAS = 10; // Máximo de pistas disponibles

    /**
     * Constructor que inicializa las reservas y el gestor de iluminación.
     */
    public Sistema() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion(MAX_PISTAS);
    }

    /**
     * Realiza una reserva para una pista en una fecha específica y duración dada.
     * 
     * @param reserva Objeto de tipo Reserva que contiene la pista, la fecha y la duración de la reserva.
     * @return true si la reserva se ha realizado correctamente, false si la pista ya está reservada.
     */
    public boolean reservarPista(Reservas reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false; // La pista no está disponible
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva existente basándose en el ID de la pista.
     * 
     * @param idPista El ID de la pista cuya reserva se desea cancelar.
     * @return true si la reserva fue cancelada correctamente, false si no se encontró la reserva.
     */
    public boolean cancelarReserva(int idPista) {
        return reservas.removeIf(r -> r.getIdPista() == idPista);
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha específica.
     * 
     * @param idPista El ID de la pista a verificar.
     * @param fecha La fecha en la que se desea verificar la disponibilidad.
     * @return true si la pista está disponible, false si ya está reservada en esa fecha.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha) {
        return esFechaDisponible(idPista, fecha);
    }

    /**
     * Método privado que verifica si una fecha está disponible para una pista específica.
     * 
     * @param idPista El ID de la pista.
     * @param fecha La fecha a verificar.
     * @return true si la fecha está disponible, false si ya está reservada.
     */
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
        for (Reservas r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Encender las luces de una pista específica.
     * 
     * @param idPista El ID de la pista para encender las luces.
     * @return true si las luces se encendieron correctamente, false si el ID de la pista es inválido.
     */
    public boolean encenderLuces(int idPista) {
        return gestorIluminacion.encenderLuces(idPista);
    }

    /**
     * Apagar las luces de una pista específica.
     * 
     * @param idPista El ID de la pista para apagar las luces.
     * @return true si las luces se apagaron correctamente, false si el ID de la pista es inválido.
     */
    public boolean apagarLuces(int idPista) {
        return gestorIluminacion.apagarLuces(idPista);
    }
}
