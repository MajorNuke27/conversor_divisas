package conversor_divisas.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import conversor_divisas.model.Divisa;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Esau Montiel
 */
public abstract class DeserializationService {
    
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static ArrayList<Divisa> buildDivisasList(String jsonString) throws JsonProcessingException {
        
        ArrayList<Divisa> lista = new ArrayList<>(163);
        
        mapper.readTree(jsonString).get("rates").fields().forEachRemaining( divisa -> {
        
            lista.add(new Divisa(divisa.getValue().get("currency_name").asText(), divisa.getKey(), Float.parseFloat(divisa.getValue().get("rate").asText())));
            
        });
        
        return lista;
        
    }
    
    public static LocalDate getFecha(String jsonString) throws JsonProcessingException {
        String fecha = mapper.readTree(jsonString).get("updated_date").asText();
        
        return LocalDate.parse(fecha);
    }
    
}
