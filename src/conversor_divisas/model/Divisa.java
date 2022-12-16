package conversor_divisas.model;

/**
 *
 * @author Esau Montiel
 */

public class Divisa {
    
    private final String nombre;
    private final String clave;

    
    /**
     * Crea una instancia de un objeto del tipo Divisa.
     * 
     * @param nombre Nombre completo de la divisa.
     * @param clave Clave de 3 caracteres que identifica a la divisa.
     */
    public Divisa(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
    
    @Override
    public String toString() {
        return this.nombre + " (" + this.clave + ")";
    }   
    
}
