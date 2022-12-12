package conversor_divisas.model;

import java.util.HashMap;

/**
 *
 * @author Esau Montiel
 */

public class Divisa {
    
    
    private final String nombre;
    private final String clave;
    private final HashMap<String, Float> equivalencias;

    
    /**
     * Crea una instancia de un objeto del tipo Divisa.
     * 
     * @param nombre Nombre completo de la divisa.
     * @param clave Clave de 3 caracteres que identifica a la divisa.
     */
    public Divisa(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        this.equivalencias = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }
    
    public void addEquivalencia(String clave, float valor) {
        this.equivalencias.put(clave, valor);
    }
    
    public boolean containsEquivalencia(String clave) {
        return this.equivalencias.containsKey(clave);
    }
    
    /**
     * Obtiene la equivalencia de esta divisa con respecto a la de la clave ingresada.
     * 
     * @param clave Clave de la divisa cuya equivalencia se quiere obtener.
     * @return Si la equivalencia existe, la retorna. De no ser así, retornara 0.
     */
    public float getEquivalencia(String clave) {
        
        if(this.containsEquivalencia(clave)) return this.equivalencias.get(clave);
        
        return 0;
    }
    
    @Override
    public String toString() {
        return this.nombre + "(" + this.clave + ")";
    }   
    
}
