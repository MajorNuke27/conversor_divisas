package conversor_divisas.model;

/**
 *
 * @author Esau Montiel
 */

public class Divisa {
    
    private final String nombre;
    private final String clave;
    private final float equivalencia;

    
    /**
     * Crea una instancia de un objeto del tipo Divisa.
     * 
     * @param nombre Nombre completo de la divisa.
     * @param clave Clave de 3 caracteres que identifica a la divisa.
     * @param equivalencia: equivalencia de esta divisa con respecto a una divisa base.
     */
    public Divisa(String nombre, String clave, float equivalencia) {
        this.nombre = nombre;
        this.clave = clave;
        this.equivalencia = equivalencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
    
    public float getEquivalencia() {
        return equivalencia;
    }
    
    @Override
    public String toString() {
        return this.nombre + " (" + this.clave + ")";
    }
    
}
