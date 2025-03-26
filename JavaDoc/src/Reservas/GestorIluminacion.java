package Reservas;

/**
 * Clase que gestiona la iluminación de las pistas deportivas.
 * 
 * @author Yessenia Martinez
 */
public class GestorIluminacion {
    
    private boolean[] iluminacion;

    /**
     * Constructor que inicializa el sistema de iluminación.
     * 
     * @param numPistas Número total de pistas en el sistema.
     */
    public GestorIluminacion(int numPistas) {
        iluminacion = new boolean[numPistas];
    }

    /**
     * Enciende las luces de una pista específica.
     * 
     * @param idPista El ID de la pista para encender las luces.
     * @return true si las luces se encendieron correctamente, false si el ID de la pista es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
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
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
}
