package conversor_divisas.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import conversor_divisas.model.Divisa;
import conversor_divisas.model.DivisaBase;
import java.util.ArrayList;

/**
 *
 * @author Esau Montiel
 */
public abstract class DeserializationService {
    
    public static final int INDEX_OF_BASE = 0;
    
    public static ArrayList<Divisa> buildDivisasList(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Divisa> lista = new ArrayList<>(163);
        
        lista.add(mapper.readValue(jsonString, DivisaBase.class));
        
        mapper.readTree(jsonString).get("rates").fields().forEachRemaining( divisa -> {
        
            if(!divisa.getKey().equals("EUR"))
                lista.add(new Divisa(divisa.getValue().get("currency_name").asText(), divisa.getKey()));
            
        });
        
        return lista;
    }
}
