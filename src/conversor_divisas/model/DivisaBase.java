package conversor_divisas.model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author Esau Montiel
 */
public class DivisaBase extends Divisa{

    private final HashMap<String, Float> equivalencias;
    private final LocalDate fecha;
    
    /**
     * 
     * Instancia un objeto del tipo DivisaBase.
     * 
     * @param nombre Nombre completo de la divisa.
     * @param clave Clave de 3 caracteres que identifica a la divisa.
     * @param equivalencias HashMap que almacena la relacion de una clave de divisa, 
     * con su equivalencia. Con esto sabemos que 1 DivisaBase = X Divisa(s);
     */
    public DivisaBase(String nombre, String clave, HashMap equivalencias, LocalDate fecha) {
        super(nombre, clave);
        this.equivalencias = new HashMap<>(equivalencias);
        this.fecha = fecha;
    }
    
    /**
     * 
     * Obtiene la equivalencia de 1 Divisa base en la Divisa ingresada
     * 
     * @param clave: Clave de la divisa de la cual se quiere obtener su equivalencia.
     * @return La equivalencia de 1 Divisa base en la Divisa ingresada.
     */
    public float getEquivalencia(String clave) {
        return this.equivalencias.get(clave);
    }
    
    public LocalDate getFecha () {
        return fecha;
    }

}
