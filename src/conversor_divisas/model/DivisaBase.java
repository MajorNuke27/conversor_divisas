package conversor_divisas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.LocalDate;
import java.util.HashMap;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Esau Montiel
 */

@JsonDeserialize(builder = DivisaBase.Builder.class)
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
     * @param fecha Fecha en la que se obtuvieron las equivalencias de las divisas.
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
    
    public Map<String, Float> getEquivalenciasMap() {
        return Collections.unmodifiableMap(equivalencias);
    }
    
    public LocalDate getFecha () {
        return fecha;
    }
    
    
    @JsonPOJOBuilder(withPrefix = "set")
    static class Builder {
        
        @JsonProperty("base_currency_name")
        String nombre;
        @JsonProperty("base_currency_code")
        String clave;
        @JsonProperty("rates")
        HashMap<String, Float> equivalencias;
        @JsonProperty("updated_date")
        LocalDate fecha;
        
        @JsonIgnore
        public String amount;
        @JsonIgnore
        public String status;
        
        Builder setFecha(String fecha) {
            this.fecha = LocalDate.parse(fecha);
            return this;
        }
        
        Builder setEquivalencias (JsonNode rates) {
            
            HashMap<String, Float> map = new HashMap<>(162);
            
            rates.fields().forEachRemaining((divisa) -> {
            
                map.put(divisa.getKey(), Float.parseFloat(divisa.getValue().get("rate").asText()));
                
            });
            
            this.equivalencias = map;
            
            return this;
        }
        
        public DivisaBase build() {
            return new DivisaBase(nombre, clave, equivalencias, fecha);
        }
        
    }

}
