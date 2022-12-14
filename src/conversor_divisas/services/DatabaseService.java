package conversor_divisas.services;

import conversor_divisas.model.Database;
import conversor_divisas.model.Divisa;
import conversor_divisas.model.DivisaBase;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Esau Montiel
 */
public class DatabaseService extends Database {
    
    private HashMap<String, Float> equivalencias;
    private ArrayList<Divisa> divisas;
    private DivisaBase divisaBase;
    
    
    public DatabaseService () throws ClassNotFoundException, SQLException {
        super();
    }
    
    /**
     * 
     * Obtiene todos los datos necesarios sobre las divisas y sus cambios de la base de datos.
     * 
     * @throws SQLException 
     */
    private void retrieveData() throws SQLException {
        
        ArrayList<Divisa> divisasObj = new ArrayList<>(163);
        ArrayList<String[]> divisasString = super.ejecutarQuery("SELECT * FROM divisa ORDER BY valor_de_cambio ASC", 3, 163);
        HashMap<String, Float> equivalencias = new HashMap<>(162);
        
        divisasString.forEach( divisa -> {
            
            divisasObj.add(new Divisa(divisa[1], divisa[0]));
            equivalencias.put(divisa[0], Float.parseFloat(divisa[2]));
            
        });

        String fecha = super.ejecutarQuery("SELECT fecha FROM divisa_base", "fecha");
        fecha = fecha.substring(0, fecha.indexOf(' '));
        LocalDate fechaObj = LocalDate.parse(fecha);
        
        Divisa base = divisasObj.get(0);
        this.divisaBase = new DivisaBase(base.getNombre(), base.getClave(), equivalencias, fechaObj);
        divisasObj.set(0, this.divisaBase);
        
        this.equivalencias = equivalencias;
        this.divisas = divisasObj;

    }
    
    public void setNewEquivalencias(HashMap<String, Float> equivalencias) throws SQLException {
        
        String[] claves = (String[]) equivalencias.keySet().toArray();
        
        for(String clave : claves) {
            float equiv = equivalencias.get(clave);
            super.ejecutarUpdate("UPDATE divisa SET valor_de_cambio = " + equiv + " WHERE clave = '" + clave + "'");
        }
        
    }
 
    public ArrayList<Divisa> getDivisas() throws SQLException {
        if(this.divisas == null) this.retrieveData();
        return divisas;
    }
    
    public DivisaBase getDivisaBase() throws SQLException {
        if(this.divisaBase == null) this.retrieveData();
        return divisaBase;
    }

    public HashMap<String, Float> getEquivalencias() throws SQLException {
        if(this.equivalencias == null) this.retrieveData();
        return equivalencias;
    }
    
}
