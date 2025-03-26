package Reservas;

import java.time.LocalDate;

/**
 * Clase que representa una reserva para una pista deportiva, incluyendo la pista,
 * la fecha y la duración de la reserva.
 * 
 * @author Yessenia Martinez
 */
public class Reservas {
    
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    /**
     * Constructor que inicializa la reserva con la pista, fecha y duración.
     * 
     * @param idPista El ID de la pista reservada.
     * @param fecha La fecha en la que se realiza la reserva.
     * @param duracion La duración de la reserva en minutos.
     */
    public Reservas(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public int getIdPista() {
        return idPista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }
}
